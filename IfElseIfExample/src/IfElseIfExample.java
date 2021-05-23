
public class IfElseIfExample {
	public static void main(String[] args) {
		int num = 1234;
		if(num<100 && num>10) {
			System.out.println("It is two digit number");
		}
		else if(num<1000 && num>100) {
			System.out.println("It is three digit number");
		}
		else if(num<10000 && num>1000) {
			System.out.println("it is four digit number");
		}
		else if(num<100000 && num>10000) {
			System.out.println("it is five digit number");
		}
		else {
			System.out.println("Number is not between 10 and 99999");
		}
	}

}
