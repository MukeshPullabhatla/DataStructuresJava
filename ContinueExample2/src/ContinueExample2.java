
public class ContinueExample2 {
	public static void main(String[] args) {
		int i = 10;
		while(i>=0) {
			if(i==7) {
				i--;
				continue;
			}
			System.out.println(i);
			i--;
		}
	}

}
