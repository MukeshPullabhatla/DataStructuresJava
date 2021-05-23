
public class NestedIfExample {
	public static void main(String[] args) {
		int num = 70;
		if(num<100) {
			System.out.println("num is less than 100");
			if(num>50) {
				System.out.println("num is greater than 50");
			}
		}
	}

}
