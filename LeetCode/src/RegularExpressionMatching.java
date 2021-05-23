
public class RegularExpressionMatching {
	public boolean isMatch(String text, String pattern) {
		if(pattern.isEmpty())
			return text.isEmpty();
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
		
		if(pattern.length() >=2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
			
		}else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}
	
	public static void main(String[] args) {
		String text = "mississippi";
		String pattern = "mis*is*p*";
		RegularExpressionMatching bool = new RegularExpressionMatching();
		boolean result = bool.isMatch(text, pattern);
		System.out.println(result);
	}

}
