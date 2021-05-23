import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Admin{

    public static void main(String[] args) {

        HashSet<Integer> hashSetPrts = new HashSet<>();
        if (args.length == 0) {
            System.out.println("Give the directoy path");
            return;
        } else if (args.length > 1) {
            System.out.println("Incorrect Input Format, more than one parameter entered");
            return;
        }

        String path1 = args[0];
        File path = new File(path1);

        if (!path.isDirectory()) {
            System.out.println("Given directoy path is Incorrect");
            return;
        }
        File data[] = path.listFiles();
        int size = data.length;
        int[] prts = new int[size];
        String allNodes = "";

        System.out.println("Initilizing of Port number to " + size + " Routers");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < size; i++) {
            String val = data[i].getName();
            val = val.substring(0, val.indexOf(".dat"));
            System.out.println("Enter the port number for Router: " + val);

            boolean status = true;

            while (status) {
                try {
                    int number = Integer.parseInt(scanner.nextLine());

                    if (number <= 1024 || number >= 65536) {
                        throw new NumberFormatException();
                    }
                    if (hashSetPrts.contains(number)) {
                        throw new Exception();
                    }
                    prts[i] = number;
                    hashSetPrts.add(number);
                    status = false;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid Port number that is > 1024 && < 65536");
                    status = true;
                } catch (Exception e) {
                    System.out.println("Address is Already being used");
                    status = true;
                }
            }
            allNodes += " " + val + ":" + prts[i];
        }

        scanner.close();

        for (int i = 0; i < size; i++) {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "start java MainRouter " + (i + 1) + " \""
                    + data[i].getParent().replace("\\", "/") + "\" " + size + allNodes);

            try {
                processBuilder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Distance Vector Algorithm Started");

    }

}

