
public class Example3 {
	private int var;
	public Example3(int num) {
		this.var = num;
	}
	public int getValue() {
		return var;
	}
	public static void main(String[] args) {
		Example3 myObj = new Example3(120);
		System.out.println("Var is: " +myObj.getValue());
	}

}
