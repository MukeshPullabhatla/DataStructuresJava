import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.BufferedReader;
import java.net.InetAddress;
import java.net.SocketException;


/**
 * @author Mukesh, Bharat, Mounika
 *
 */
public class Slave {
	// initialization of required variables for application of DVR
	public static DatagramSocket routerSocket;
    public static File routerFile;
	public static double[] routerMyVector;
    public static double[][] routerVectors;
    public static String[] routerNodes,listNextHop,routersNeighbouring;
    public static int[] routerPorts;
	public static int routerId,routersCount = 1;
    
    
    /**
     * @param args
     */
    public static void main(String args[]) {
    	// Accessing the arguments from the main method.
        int totalLength = Integer.parseInt(args[2]); // total length value from the arguments.
        int currentRId = Integer.parseInt(args[0]); // current router Id from the arguments
        String path = args[1]; // path from the arguments
        
        setParams(totalLength, args, currentRId, path);
        
        ActionThread writeThread = new ActionThread("w");
        // starting an action thread to write action;
        writeThread.start();

        ActionThread readThread = new ActionThread("r");
        // starting an action thread to read action; 
        readThread.start();
        // looping to run the process until the user termination.
        while (true)
            ;
    }
    
    
    
    /**
     * Distance vector Algorithm logic to find the shortest path
     * no return statements or method arguments
     */
    public static void distanceVectorRoutingAlgorithm() {

    	// iteration over accessing the neighboring nodes.
        for (int i = 0; i < routersNeighbouring.length; i++) {
        	// accessing the index nodes costs.
            int index = findIndex(routersNeighbouring[i]);
            // iteration to find the next hop for shortest path
            for (int j = 0; j < routerMyVector.length; j++) {
                if (j == routerId - 1) {
                    continue;
                } else if (i == 0) {

                    routerMyVector[j] = routerVectors[routerId - 1][index] + routerVectors[index][j];
                    listNextHop[j] = routersNeighbouring[i];
                } else {

                    if (routerMyVector[j] > routerVectors[routerId - 1][index] + routerVectors[index][j]) {
                        listNextHop[j] = routersNeighbouring[i];
                        routerMyVector[j] = routerVectors[routerId - 1][index] + routerVectors[index][j];
                    }

                }
            }
        }


    }



    /**
     * @param vector
     * @param portNum
     * method to update cost of shortest path.
     */
    public synchronized static void updateDistanceVectors(String[] vector, int portNum) {

        int index = 0;
        int portLength=routerPorts.length;
        // iteration over port length
        while(index < portLength)
        {
            if (routerPorts[index] == portNum)
            {
                break;
            }
            index++;
        }
        if (index == portLength)
        {
            return;
        }
        for (int i = 0; i < vector.length; i++)
        {
            routerVectors[index][i] = Double.parseDouble(vector[i]);
        }
    }
    

    
    /**
     * @param length
     * @param args
     * @param RId
     * @param parentPath
     */
    public static void setParams(int length, String[] args, int RId, String parentPath) {
    	
    	//  initializing and assigning the values of global static variables(routerId,routerVectors,routerPorts,routerNodes).
    	routerId = RId;
        routerVectors = new double[length][length];
        routerPorts = new int[length];
        routerNodes = new String[length];
        // accessing routerNodes and routerPorts through iterating over length
        for (int i = 0; i < length; i++) {
            Arrays.fill(routerVectors[i], Double.MAX_VALUE);
            routerVectors[i][i] = 0.0;
            String[] temp = args[i + 3].split(":");
            routerNodes[i] = temp[0];
            routerPorts[i] = Integer.parseInt(temp[1]);
        }
        
        routerMyVector = new double[length];
        listNextHop = new String[length];
        Arrays.fill(routerMyVector, Double.MAX_VALUE);
        routerMyVector[routerId - 1] = 0.0;
        routerFile = new File(parentPath + "/" + routerNodes[routerId - 1] + ".dat");
        // accessing socket
        try {
            routerSocket = new DatagramSocket(routerPorts[routerId - 1]);
        } catch (SocketException e) {

            e.printStackTrace();
        }
        
        System.out.println("Router# " + routerNodes[routerId - 1] + " is Working");

    }
    
    
    
    /**
     * method to read routers.
     * no return statements or method arguments.
     */
    public static void read() {
    	
        try {
            Arrays.fill(routerVectors[routerId - 1], Double.MAX_VALUE);
            routerVectors[routerId - 1][routerId - 1] = 0.0;
            BufferedReader bReader = new BufferedReader(new FileReader(routerFile));
            int length = Integer.parseInt(bReader.readLine());// accessing length from the router file 
            routersNeighbouring = new String[length];
            // iteration over length
            for (int i = 0; i < length; i++) {

                String[] temp = bReader.readLine().split(" ");
                int index = findIndex(temp[0]);
                routersNeighbouring[i] = temp[0];

                if (routersCount == 1) {
                    listNextHop[index] = temp[0];
                    routerMyVector[index] = Double.parseDouble(temp[1]);
                } else {

                }
                routerVectors[routerId - 1][index] = Double.parseDouble(temp[1]);

            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * no return statements or method arguments.
     * reading the data from socket. 
     */
    public static void readPacketData() {
    	 // looping to run the process until the user termination.
        boolean check = true;
        while (check) {
            try {
                String action = "u";
                byte[] data = new byte[1024];
                int size = data.length;
                DatagramPacket packet = new DatagramPacket(data, size);
                routerSocket.receive(packet);
                int length = packet.getLength();
                String vector = new String(packet.getData(), 0, length);
                ActionThread updateThread = new ActionThread(action, vector, packet.getPort());
                updateThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    /**
     * no return statements or method arguments.
     * method to display the shortest path cost and next hop output.
     */
    public static void output() {
        System.out.println("Output Number is " + routersCount++);
        System.out.println();
        String src = routerNodes[routerId - 1];
        for (int i = 0; i < routerMyVector.length; i++) {
            if (i != (routerId - 1)) {
                String dest = routerNodes[i];
                if (routerMyVector[i] == Double.MAX_VALUE) {
                    System.out.println("shortest path from " + src + "-" + dest + ": " + " route not found");
                } else {
                    System.out.println("shortest path from " + src + "-" + dest + " : next hop is " + listNextHop[i]
                            + " and cost is " + routerMyVector[i]);
                }
            }
        }

    }
    
    

    

    /**
     * @param temp
     * @return
     * method to find the index value
     */
    public static int findIndex(String temp) {
        int pos = -1;
        for (int i = 0; i < routerNodes.length; i++) {
            if (routerNodes[i].equals(temp)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
	
	    

    /**
     * no return statements or method arguments.
     * method to broadcast the updated forwarding table to neighbouring routers
     */
    public static void broadCastToNeighbours() {

        try {
            for (int i = 0; i < routersNeighbouring.length; i++) {
                String data = "";
                for (int j = 0; j < routerMyVector.length; j++) {
                    if (routersNeighbouring[i].equals(listNextHop[j])) {
                        data = data + Double.MAX_VALUE + ":";
                    } else {
                        data += routerMyVector[j] + ":";
                    }
                }
                DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length);
                packet.setAddress(InetAddress.getByName("localhost"));
                packet.setPort(routerPorts[findIndex(routersNeighbouring[i])]);
                routerSocket.send(packet);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

/**
 * @author Bharat, Mukesh, Mounika.
 * Class for thread creation to continuously process read write and update operations.
 *
 */
class ActionThread extends Thread {

    private String action;
    private String vector;
    private int portNum;


    /**
     * @param action
     * @param vector
     * @param port
     */
    public ActionThread(String action, String vector, int port) {
        this.action = action;
        this.vector = vector;
        this.portNum = port;
    }

    /**
     * @param action
     */
    public ActionThread(String action) {
        this.action = action;
    }

    /**
     *no return statements or method arguments.
     */
    public void run() {

        if (action.equalsIgnoreCase("r")) {
            Slave.readPacketData();

        } else if (action.equalsIgnoreCase("w")) {

            while (true) {
                try {

                    Slave.read();
                    Slave.output();
                    Slave.broadCastToNeighbours();
                    // sleep time for thread to maintain a buffer time for 7000 millisec
                    Thread.sleep(7000);

                    Slave.distanceVectorRoutingAlgorithm();
                    // sleep time for thread to maintain a buffer time for 8000 millisec
                    Thread.sleep(8000);

                } catch (Exception e) {
                }
            }
        } else if (action.equalsIgnoreCase("u")) {

            Slave.updateDistanceVectors(vector.split(":"), portNum);
        }
    }

}
