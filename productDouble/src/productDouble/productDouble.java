package productDouble;
import java.util.Scanner;
public class productDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			System.out.println("enter first number: ");
			double num1 = scan.nextDouble();
			System.out.println("enter second number: ");
			double num2 = scan.nextDouble();
			double product = num1*num2;
			System.out.println("output: " +product);
	}

}
