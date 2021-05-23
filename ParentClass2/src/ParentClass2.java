
public class ParentClass2 {
//	parent class constructor
	ParentClass2(){
		System.out.println("Constructor of parent");
	}
	void disp() {
		System.out.println("Parent Method");
	}

}
class JavaExample extends ParentClass2{
	JavaExample(){
		System.out.println("Constructor of Child");
	}
	void disp() {
		System.out.println("Child Method");
//		calling the display method of parent class
		super.disp();
	}
	public static void main(String[] args) {
//		creating the object of child class
		JavaExample obj = new JavaExample();
		obj.disp();
	}
}
