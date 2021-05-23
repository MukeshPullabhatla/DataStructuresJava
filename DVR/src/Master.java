import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


/**
 * @author Mukesh, Bharat, Mounika
 *
 */
public class Master {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// creating Hashset variable to give port for evey node
        HashSet<Integer> portSet = new HashSet<>();
        String path = args[0]; // reading the file from main method arguments
        
        File dirPath = new File(path); // accesing file directory path
        // validation to check the input arguments of file path
        if(argumentsValidation(args, dirPath)) {
        return;	
        }
        // Accessing data from the file
        File data[] = dirPath.listFiles();
        int dataSize = data.length;
        int[] ports = new int[dataSize];
        String dvNodes = "";
        System.out.println("Port number initialization to " + dataSize + " routers");
        //validation of input numbers from scanner and accessing the distance vector nodes
        dvNodes = portInputs(portSet, data, dataSize, ports, dvNodes);
        // code for sending to slave.
        for (int i = 0; i < dataSize; i++) {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "start java Slave " + (i + 1) + " \"" + data[i].getParent().replace("\\", "/") + "\" " + dataSize + dvNodes);
            try {
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Started Distance Vector Algorithm....");
    }

	/**
	 * @param portSet
	 * @param data
	 * @param dataSize
	 * @param ports
	 * @param dvNodes
	 * @return
	 */
	private static String portInputs(HashSet<Integer> portSet, File[] data, int dataSize, int[] ports, String dvNodes) {
		Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < dataSize; i++) {
            String rNum = data[i].getName();
            rNum = rNum.substring(0, rNum.indexOf(".dat"));
            System.out.println("Enter port number of Router - " + rNum);
            boolean check = true;
            while (check) {
                try {
                    int portNum = Integer.parseInt(scanner.nextLine());
                    if (portNum <= 1024 || portNum >= 65536) 
                        throw new NumberFormatException();
                    if (portSet.contains(portNum)) 
                        throw new Exception();
                    check = false;
                    ports[i] = portNum;
                    portSet.add(portNum);
                } catch (NumberFormatException e) {
                    System.out.println("Enter valid Port number between 1024 and 65536.");
                    check = true;
                } catch (Exception e) {
                    System.out.println("Port already in use");
                    check = true;
                }
            }
            dvNodes=dvNodes+ " " + rNum + ":" + ports[i];
        }
        scanner.close();
		return dvNodes;
	}

	/**
	 * @param args
	 * @param dirPath
	 */
	private static boolean argumentsValidation(String[] args, File dirPath) {
		boolean flag=false;
		if (args.length == 0) {
            System.out.println("Enter file location");
            flag= true;
        } else if (args.length > 1) {
            System.out.println("Input Format is Incorrect:More than one parameter is entered");
            flag= true;
        }
        if (!dirPath.isDirectory()) {
            System.out.println(" Entered Path is not correct");
            flag= true;
        }
        return flag;
	}
}
