
public class Teacher1 {
	private String designation = "teacher";
	private String collegeName = "beginnersbook";
	public String getDesignation() {
		return designation;
	}
	protected void setDesignation(String designation) {
		this.designation = designation;
	}
	protected String getCollegeName() {
		return collegeName;
	}
	protected void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	void does() {
		System.out.println("teaching");
	}
}
class JavaExample extends Teacher1{
	String mainSubject = "physics";
	public static void main(String[] args) {
		JavaExample obj = new JavaExample();
		/*
		 * Note: we are not accessing the data members directly. we are using public
		 * getter method to access the private members of parent class
		 */
		System.out.println(obj.getCollegeName());
		System.out.println(obj.getDesignation());
		System.out.println(obj.mainSubject);
		obj.does();
	}

}
