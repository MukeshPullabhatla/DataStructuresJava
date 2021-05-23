
public class JavaCopyConstructor {
	String web;
	JavaCopyConstructor(String w){
		web = w;
	}
	JavaCopyConstructor(JavaCopyConstructor je){
		web = je.web;
	}
	void disp() {
		System.out.println("website: " +web);
	}
	public static void main(String args[]) {
		JavaCopyConstructor obj = new JavaCopyConstructor("Beginners Book");
		JavaCopyConstructor obj1 = new JavaCopyConstructor(obj);
		obj.disp();
		obj1.disp();
	}

}
