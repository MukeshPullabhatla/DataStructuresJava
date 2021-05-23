//parent class or superclass or base class
public class SuperClass {
	int num = 100;
}
//child class or subclass or derived class
class Subclass extends SuperClass
{
	/* the same variable num is declared in the subclass
	 * which is already present in the super class
	 */
	int num = 110;
	void printNumber() {
		System.out.println(num);
	}
	public static void main(String args[]) {
		Subclass obj = new Subclass();
		obj.printNumber();
	}
	
}
