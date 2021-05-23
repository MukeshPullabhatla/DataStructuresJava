
public class Superclass1 {
	int num = 100;
}
class Subclass1 extends Superclass1{
	int num = 110;

void printNumber() {
	System.out.println(super.num);
}
public static void main(String args[]) {
	Subclass1 obj = new Subclass1();
	obj.printNumber();
}
}
