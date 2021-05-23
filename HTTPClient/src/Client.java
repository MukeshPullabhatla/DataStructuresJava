

import java.io.*;
import java.net.Socket;

public class Client {

    static final File WEB_ROOT = new File(".");

    // verbose mode
    static final boolean verbose = true;

    public static void main(String[] args) {
    	//Checking Syntax
    	if (!(args.length == 4)) {
    		errorCheckOnLength(args);
			return;
        }
    	    	
    	//Details from the arguments
        String hostName = args[0];
        int port = Integer.parseInt(args[1]);
        String method = args[2];
        String fileName = args[3];

        //Checking type of connection
        if (!method.equals("GET") && !method.equals("PUT")) {
            sytnaxCheckOnMethodType();
            return;
        }
        //Establishing Connection
        try {
            Socket socket = new Socket(hostName, port);

            if (method.equals("GET")) {
                methodGET(socket, hostName, fileName);
            }

            if (method.equals("PUT")) {
                methodPUT(socket, hostName, fileName);
            }

            socket.close();

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }

	/**
	 * 
	 */
	private static void sytnaxCheckOnMethodType() {
		System.out.println("Connection failed, given wrong Syntax");
		
		System.out.print("Given Syntax: ");
		
		System.out.println("Expected Syntax format : ");
		System.out.println("java Client Hostname Port GET|PUT FileName");
		System.out.println("Only GET and PUT are supported");
	}

	/**
	 * @param args
	 */
	private static void errorCheckOnLength(String[] args) {
		System.out.println("Connection not established, given wrong Syntax format");
		
		System.out.print("Given Syntax: ");
		for (Object var : args) {
		    System.out.printf("%s ", var);
		}
		System.out.println("Expected Syntax format : ");
		System.out.println("java Client Hostname Port GET|PUT FileName");
		
	}

    public static void methodGET(Socket socket, String hostName, String fileName) {
        PrintWriter out = null;
        BufferedInputStream dataIn = null;
        BufferedOutputStream dataOut = null;

       

        try {
            dataIn = new BufferedInputStream(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
            dataOut = new BufferedOutputStream(socket.getOutputStream());

            // send HTTP Headers
            httpHeaders(hostName, fileName, out);

            // get first line of the request from the client
            byte[] bytes = new byte[8192];
            int byteCount = 0;

            byteCount = dataIn.read(bytes);
            System.out.println("Read " + byteCount + " bytes for header.");
            if (byteCount == -1) {

                System.out.println("Error 404:\nFile Not found");

            } else {


                byte[] small = new byte[]{13, 10, 13, 10};
                int start = indexOf(bytes, small) + 4;

                String revisedFileName = fileName;
                if (fileName.equals("/")) {
                    revisedFileName = "index.html";
                }

                FileOutputStream fc = new FileOutputStream(new File(WEB_ROOT, revisedFileName));
                fc.write(bytes, start, byteCount - start);
		 System.out.println("200 OK: \nThe requested file "+fileName+" is brought from the Server");

                if (byteCount != -1) {
                    while (true) {
                        byteCount = dataIn.read(bytes);
                        System.out.println("Read more " + byteCount + " bytes");
                        if (byteCount > 0) {
                            fc.write(bytes, 0, byteCount);
                        }

                        if (byteCount == -1) {
                            break;
                        }
                    }
                }
                fc.close();

            }
        }catch (IOException ioe) {
            System.err.println("Server error : " + ioe);
        } finally {
            try {
                dataIn.close();
                out.close();
                dataOut.close();
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }

            if (verbose) {
                System.out.println("Connection closed.\n");
            }
        }

    }

	/**
	 * @param hostName
	 * @param fileName
	 * @param out
	 */
	private static void httpHeaders(String hostName, String fileName, PrintWriter out) {
		out.println("GET " + fileName);
		out.println("User-Agent: JavaHttpClient");
		out.println("Host: " + hostName);
		out.println("Accept-Language: en-us");
		out.println();// blank line between headers and content, very important !
		out.flush(); // flush character output stream buffer
	}

    public static void methodPUT(Socket socket, String hostName, String fileName) {
        PrintWriter out = null;
        BufferedInputStream dataIn = null;
        BufferedOutputStream dataOut = null;

        try {
            dataIn = new BufferedInputStream(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
            dataOut = new BufferedOutputStream(socket.getOutputStream());

            File file = new File(WEB_ROOT, fileName);
            int fileLength = (int) file.length();
            byte[] fileData = readFileData(file, fileLength);

            // send HTTP Headers
            out.println("PUT " + fileName);
            out.println("Host: " + hostName);
            out.println();// blank line between headers and content, very important !
            out.flush(); // flush character output stream buffer

            dataOut.write(fileData, 0, fileLength);
            dataOut.flush();
	    System.out.println("200 OK: \nThe requested file "+fileName+" is successfully updated in the Server");

        } catch (IOException ioe) {
            System.err.println("Error 404:\n File Not Found");
        } finally {
            try {
                dataIn.close();
                out.close();
                dataOut.close();
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }

            // if (verbose) {
            //     System.out.println("Connection closed.\n");
            // }
        }

    }


    public static int indexOf(byte[] outerArray, byte[] smallerArray) {
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

    private static byte[] readFileData(File file, int fileLength) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }

        return fileData;
    }

}
