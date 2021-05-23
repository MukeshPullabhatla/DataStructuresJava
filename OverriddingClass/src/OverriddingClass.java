
public class OverriddingClass {
	//overridden method
	void display() {
		System.out.println("Parent class method");
	}
}
class Subclass extends OverriddingClass{
	//overridding method
	void display() {
		System.out.println("child class method");
	}
	void printMsg() {
		//This would call overridding method
		display();
		//This would call overridded method
		super.display();
	}
	public static void main(String args[]) {
		Subclass obj = new Subclass();
		obj.printMsg();
	}

}
