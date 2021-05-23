import java.util.Scanner;

public class BinarySwapingusingBitwiseXOR {
	public static void main(String[] args) {
		int num1,num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 1st number: ");
		num1 = sc.nextInt();
		System.out.println("Enter the 2nd number: ");
		num2 = sc.nextInt();
		num1 = num1^num2;
		num2 = num1^num2;
		num1 = num1^num2;
		System.out.println("1st number after swaping: "+num1);
		System.out.println("2nd number after swaping: "+num2);
	}

}
