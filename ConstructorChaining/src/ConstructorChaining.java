
public class ConstructorChaining {
	public String empName;
	public int empSalary;
	public String address;
	//default constructor of the class
	public ConstructorChaining() {
		//this will call the constructor with string param
		this("Mukesh");
	}
	public ConstructorChaining(String name) {
		//call the constructor with (String,int) param
		this(name,1000000000);
	}
	public ConstructorChaining(String name, int sal) {
		//call the constructor with (String,int,String) param
		this(name,sal,"Hyderabad");
	}
	public ConstructorChaining(String name,int sal, String address) {
		this.empName = name;
		this.empSalary = sal;
		this.address = address;
	}
	void disp() {
		System.out.println("Employee Name: " +empName);
		System.out.println("Employee Salary: " +empSalary);
		System.out.println("Employee Address: " +address);
	}
	public static void main(String[] args) {
		ConstructorChaining obj = new ConstructorChaining();
		obj.disp();
	}

}
