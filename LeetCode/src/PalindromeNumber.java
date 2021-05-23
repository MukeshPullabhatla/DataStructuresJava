
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		
		int reverseNumber = 0;
		while(x > reverseNumber) {
			reverseNumber = reverseNumber * 10 + x % 10;
			x = x / 10;
		}
		
		return x == reverseNumber || x == reverseNumber/10;
	}
	
	public static void main(String[] args) {
		int x = 12321;
		PalindromeNumber ob = new PalindromeNumber();
		boolean result = ob.isPalindrome(x);
		System.out.println(result);
	}

}
