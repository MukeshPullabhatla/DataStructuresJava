
public class SwitchCaseExample1 {
	public static void main(String[] args) {
		int num = 2;
		switch(num+2) 
		{
		case 1:
			System.out.println("case 1: value is: " +num);
		case 2:
			System.out.println("case 2: value is: " +num);
		case 3:
			System.out.println("case 3: value is: " +num);
		default:
			System.out.println("default: value is: " +num);
		
		}
	}

}
