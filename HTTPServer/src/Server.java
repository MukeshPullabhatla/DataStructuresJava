
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

// Each Client Connection will be managed in a dedicated Thread
public class Server implements Runnable {
    static final File WEB_ROOT = new File(".");
    // verbose mode
    static final boolean verbose = true;
    // Client Connection via Socket Class
    private Socket connect;
    public Server(Socket c) {
        connect = c;
    }
    public static void main(String[] args) {
    	//Checking Syntax
        if (args.length != 1) {
            errorCheckOnLength(args);
            return;
        }
        try {
            ServerSocket serverConnection = new ServerSocket(Integer.parseInt(args[0]));
            System.out.println("Server started.\nListening for connections at the port : " + args[0] + " ...\n");
            // This will listen to the user until user stops the server execution
            while (true) {
                Server myHTTPServer = new Server(serverConnection.accept());
                if (verbose) {
                    System.out.println("New Connection opened. (" + new Date() + ")");
                }
                // create dedicated thread to manage the client connection
                Thread threadVal = new Thread(myHTTPServer);
                threadVal.start();
            }
        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }
	/**
	 * @param args
	 */
	private static void errorCheckOnLength(String[] args) {
		System.out.println("Connection not established, Syntax Error");
		System.out.print("Given Syntax: ");
		for (Object var : args) {
		    System.out.printf("%s ", var);
		}
		System.out.println("Expected Syntax format : ");
		System.out.println("java HTTPServer Port");
	}

    @Override
    public void run() {
        // we manage our particular client connection
        PrintWriter output = null;
        BufferedInputStream dataInput = null;
        BufferedOutputStream dataOutput = null;
        String requestedFile = null;
        try {
            dataInput = new BufferedInputStream(connect.getInputStream());
            output = new PrintWriter(connect.getOutputStream());
            dataOutput = new BufferedOutputStream(connect.getOutputStream());
            String mthd = new String();
            // get first line of the request from the client
            String input = new String();
            byte[] bytes = new byte[8192];
            int byteCount = 0;
            byteCount = dataInput.read(bytes);
            if (byteCount == -1) {
            } else {
                System.out.println("byteCount " + byteCount);
                input += new String(bytes, 0, byteCount, "UTF-8");
                System.out.println("Read " + byteCount + " bytes for header.");
                StringTokenizer parse = new StringTokenizer(input);
                mthd = parse.nextToken().toUpperCase(); // we get the HTTP method of the client
                // we get file requested
                requestedFile = parse.nextToken().toLowerCase();
                // we support only GET and HEAD methods, we check
                if (!mthd.equals("GET") && !mthd.equals("PUT")) {
                    if (verbose) {
                        System.out.println("501 : Only GET and PUT are available. Requested : " + mthd + " method.");
                    }
                } else if (mthd.equals("GET")) {
                    try {
                        // GET method
                        if (requestedFile.equals("/")) {
                            System.out.println("GET /index.html - Switching to default file.");
                            requestedFile = "index.html";
                        }
                        File file = new File(WEB_ROOT, requestedFile);
                        int fileLen = (int) file.length();
                        String content = getContentType(requestedFile);
                        byte[] fileData = readingFileData(file, fileLen);
                        // send HTTP Headers of GET Type
                        httpHeadersOfGET(output, dataOutput, fileLen, content, fileData);
                        if (verbose) {
                            System.out.println("File " + requestedFile + " of type " + content + " returned");
                        }
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("No file with name "+requestedFile+" in the Server");
                    }

                } else if (mthd.equals("PUT")) {
                    // PUT method
                    byte[] small = new byte[]{13, 10, 13, 10};
                    int start = indexOf(bytes, small) + 4;
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(WEB_ROOT, requestedFile));
                    fileOutputStream.write(bytes, start, byteCount - start);
                    int available = dataInput.available();
                    if (available > 0) {
                        while (true) {
                            byteCount = dataInput.read(bytes);
                            if (byteCount > 0) {
                                fileOutputStream.write(bytes, 0, byteCount);
                            }
                            available = dataInput.available();
                            // System.out.println("Available :" + available);

                            if (byteCount == -1 || available == 0) {
                                break;
                            }
                        }
                    }
                    fileOutputStream.close();
                 // send HTTP Headers of PUT Type
                    httpHeadersForPUT(output);
                    if (verbose) {
                        System.out.println("File " + requestedFile+" is updated in the Server");
                    }
                }
            }
        }catch (IOException ioe) {
            System.err.println("Server Error : " + ioe);
		
        } finally {
            try {
                dataInput.close();
                output.close();
                dataOutput.close();
                connect.close(); // we close socket connection
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }
            if (verbose) {
                System.out.println("Connection closed.\n");
            }
        }
    }
	/**
	 * @param output
	 */
	private void httpHeadersForPUT(PrintWriter output) {
		// send HTTP Headers
		output.println("HTTP/1.1 200 OK");
		output.println("Server: Java HTTP Server");
		output.println("Date: " + new Date());
		output.println();// blank line between headers and content, very important !
		output.flush(); // flush character output stream buffer
	}
	/**
	 * @param output
	 * @param dataOutput
	 * @param fileLen
	 * @param content
	 * @param fileData
	 * @throws IOException
	 */
	private void httpHeadersOfGET(PrintWriter output, BufferedOutputStream dataOutput, int fileLen, String content,
			byte[] fileData) throws IOException {
		// send HTTP Headers
		output.println("HTTP/1.1 200 OK");
		output.println("Server: Java HTTP Server");
		output.println("Date: " + new Date());
		output.println("Content-type: " + content);
		output.println("Content-length: " + fileLen);
		output.println();// blank line between headers and content, very important !
		output.flush(); // flush character output stream buffer
		dataOutput.write(fileData, 0, fileLen);
		dataOutput.flush();
	}

    public int indexOf(byte[] outerArray, byte[] smallerArray) {
        for (int i = 0; i < outerArray.length - smallerArray.length + 1; ++i) {
            boolean found = true;
            for (int j = 0; j < smallerArray.length; ++j) {
                if (outerArray[i + j] != smallerArray[j]) {
                    found = false;
                    break;
                }
            }
            if (found)
                return i;
        }
        return -1;
    }

    private byte[] readingFileData(File file, int fileLen) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLen];
        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }
        return fileData;
    }

    // return supported MIME Types
    private String getContentType(String requestedFile) {
        if (requestedFile.endsWith(".htm") || requestedFile.endsWith(".html"))
            return "text/html";
        else
            return "text/plain";
    }
    
}
