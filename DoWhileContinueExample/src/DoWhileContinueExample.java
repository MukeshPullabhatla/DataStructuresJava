
public class DoWhileContinueExample {
	public static void main(String[] args) {
		int j = 0;
		do
		{
			if(j==7)
			{
				j++;
				continue;
			}
			System.out.println(j+ " ");
			j++;
		}while(j<10);
	}

}
