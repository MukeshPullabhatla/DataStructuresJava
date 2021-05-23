class Address1 {
	int streetNum;
	String city;
	String state;
	String country;
	Address1(int street, String c, String st, String coun){
		this.streetNum = street;
		this.city = c;
		this.state = st;
		this.country = coun;
	}
}
class studentClass{
	int rollNum;
	String studentName;
	Address1 studentAddr;
	studentClass(int roll, String name, Address1 addr){
		this.rollNum = roll;
		this.studentName = name;
		this.studentAddr = addr;
	}
	public static void main(String[] args) {
		Address1 ad = new Address1(201,"chintal","hyderabad","india");
		studentClass obj = new studentClass(10,"mukesh",ad);
		System.out.println(obj.rollNum);
		System.out.println(obj.studentName);
		System.out.println(obj.studentAddr.streetNum);
		System.out.println(obj.studentAddr.city);
		System.out.println(obj.studentAddr.state);
		System.out.println(obj.studentAddr.country);
		
	}

}
class college{
	String collegeName;
	Address1 collegeAddr;
	college(String name, Address1 addr){
		this.collegeName = name;
		this.collegeAddr = addr;
	}
	public static void main(String[] args) {
		Address1 ad = new Address1(101,"king koti","hyderabad","india");
		college obj = new college("st.joseph",ad);
		System.out.println(obj.collegeName);
		System.out.println(obj.collegeAddr);
		System.out.println(obj.collegeAddr.streetNum);
		System.out.println(obj.collegeAddr.city);
		System.out.println(obj.collegeAddr.state);
		System.out.println(obj.collegeAddr.country);
		
	}

}
class staff{
	String employeeName;
	Address1 employeeAddr;
	staff(String name, Address1 addr){
		this.employeeName = name;
		this.employeeAddr = addr;
	}
	public static void main(String[] args) {
		Address1 ad = new Address1(111,"abids","hyderabad","india");
		staff obj = new staff("harsha",ad);
		System.out.println(obj.employeeName);
		System.out.println(obj.employeeAddr);
		System.out.println(obj.employeeAddr.streetNum);
		System.out.println(obj.employeeAddr.city);
		System.out.println(obj.employeeAddr.state);
		System.out.println(obj.employeeAddr.country);
		
	}
	
}
