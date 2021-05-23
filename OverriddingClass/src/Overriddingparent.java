
public class Overriddingparent {
	void display() {
		System.out.println("parent class method");
	}
}
class Subclass1 extends Overriddingparent{
 void printMsg() {
	display();
}

public static void main(String args[]) {
	Subclass1 obj = new Subclass1();
	obj.printMsg();

}
}
