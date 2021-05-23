enum Result{
	TRUE, FALSE
}
public class RegularExpressionMatchingDynamicProgramming {
	Result[][] matching;
	
	public boolean isMatch(String s, String p) {
		matching = new Result[s.length()+1][p.length()+1];
		return dp(0,0,s,p);
	}
	public boolean dp(int i, int j, String s, String p) {
		if(matching[i][j] != null) {
			return matching[i][j] == Result.TRUE;
	}
	boolean ans;
	if(j==p.length()) {
		ans = i == s.length();
	}else {
		boolean first_match = (i<s.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j) == '.'));
		if(j+1<p.length() && p.charAt(j+1) == '*') {
			ans = (dp(i,j+2,s,p) || first_match && dp(i+1,j,s,p));
		}
		else {
			ans = first_match && dp(i+1,j+1,s,p);
		}
	}
	matching[i][j] = ans ? Result.TRUE : Result.FALSE;
	return ans;

}
	public static void main(String[] args) {
		String s = "mississippi";
		String p = "mis*is*p*";
		RegularExpressionMatching bool = new RegularExpressionMatching();
		boolean result = bool.isMatch(s, p);
		System.out.println(result);
	}
}
