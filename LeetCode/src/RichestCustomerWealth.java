
public class RichestCustomerWealth {
	public static int maximumWealth(int[][] accounts) {
		int max = 0;
		for(int i=0;i<accounts.length;i++) {
			int temp = 0;
			for(int j = 0;j<accounts[i].length;j++) {
				temp+=accounts[i][j];
			}
			if(temp>max) max = temp;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[][] accounts = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		
		System.out.println(maximumWealth(accounts));
	}

}
