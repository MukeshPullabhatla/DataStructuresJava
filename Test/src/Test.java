

//public class Test {
//	static boolean x = true;
//	static boolean y = true;
//	public static void main(String[] args) {
//		x = y;
//		y= x;
//		System.out.println(x);
//		System.out.println(y);
//	}
	
//	public static void main(String[] args) {
//		int x = 1, y = 2;
//		x += x<y?y:x;
//		y = x<y?y-x:y+x;
//		System.out.println(x + " " + y);
//	}
//	
//	class Foo{
//		static String name = "Foo";
//		void print() {
//			System.out.println(this.name);
//		}
//	}
//	class Bar extends Foo{
//		String name = "Bar";
//		static void printName() {
//			super.print();
//		}
//	}
//	public class Test{
//		public static void main(String[] args) {
//			new Bar().printName();
//		}
//	
//}

public class Test{
	public static void main(String[] args) {
		int x = 1, y = 1, z = 0;
		if(x==y|x<++y) {
			z = x+y;
		}
		else {
			z = 1;
		}
		System.out.println(z);
	}
}
