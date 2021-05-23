
public class BreakExample1 {
	public static void main(String[] args) {
		int num = 0;
		while(num<=100) {
			System.out.println("value of variable is: " +num);
			if(num==10)
			{
				break;
			}
			num++;
		}
		System.out.println("Out of while-loop");
	}

}
