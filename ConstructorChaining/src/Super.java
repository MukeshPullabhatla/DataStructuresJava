
public class Super {
	Super(){
		System.out.println("MyParentClass Constructor");
	}
}
class MyChildClass extends Super{
	MyChildClass(){
		System.out.println("MyChildClass Constructor");
	}
	public static void main(String[] args) {
		new MyChildClass();
	}

}
