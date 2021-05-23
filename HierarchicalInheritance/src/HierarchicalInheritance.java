
public class HierarchicalInheritance {
	public void methodHierarchicalInheritance() {
		System.out.println("method of class A");
	}
}
class B extends HierarchicalInheritance{
	public void methodB() {
		System.out.println("method of class B");
	}
}
class C extends HierarchicalInheritance{
	public void methodC() {
		System.out.println("method of class C");
	}
}
class D extends HierarchicalInheritance{
	public void methodD() {
		System.out.println("method of class D");
	}
}
class JavaExample
{
	public static void main(String[] args) {
		B obj1 = new B();
		C obj2 = new C();
		D obj3 = new D();
//		all classes can access the method of A
		obj1.methodHierarchicalInheritance();
		obj2.methodHierarchicalInheritance();
		obj3.methodHierarchicalInheritance();
	}
}
