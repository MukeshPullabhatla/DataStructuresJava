
public class ParentClass1 {
//	parent class constructor
	ParentClass1(){
		System.out.println("Constructor of Parent");
	}
}
class JavaExample extends ParentClass1{
	JavaExample(){
		/*
		 * It by default invokes the constructor of parent class You can use super() to
		 * call the constructor of parent. It should be the first statement in the child
		 * class constructor, you can also call the parameterized constructor of parent
		 * class by using super like this: super(10), now this will invoke the
		 * paremeterized constructor of int arg
		 */
		System.out.println("Constructor of Child");
	}
	public static void main(String[] args) {
//		creating the object of child class
		new JavaExample();
	}
}
