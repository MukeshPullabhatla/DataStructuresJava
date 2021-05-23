
public class Parentclass {
	Parentclass(){
		System.out.println("Constructor of Parent class");
	}
}
class Subclass2 extends Parentclass{
	Subclass2(){
		System.out.println("constructor of child class");
	}
	Subclass2(int num){
		System.out.println("arg constructor of child class");
		
	}
void display() {
	System.out.println("Hello!");
}
public static void main(String args[]) {
	Subclass2 obj = new Subclass2();
	obj.display();
	Subclass2 obj2 = new Subclass2(10);
	obj2.display();
}
}

