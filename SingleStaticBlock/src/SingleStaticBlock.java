
public class SingleStaticBlock {
	static int num;
	static String mystr;
	static {
		num = 97;
		mystr = "Static Keyword in JAVA";
	}
	public static void main(String[] args) {
		System.out.println("Value of num: "+num);
		System.out.println("Value of String: "+mystr);
	}

}
