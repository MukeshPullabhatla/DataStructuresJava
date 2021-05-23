/**
 * 
 */


/**
 * @author MUKESH P
 * @Date   2020/09/08
 *
 */
public class User implements Comparable<User> {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String gender;
	private String city;
	private String State;

	public User(String firstName, String lastName, int age, String email, String gender, String city, String State) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.city = city;
		this.State = State;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public String toString() {
		return firstName + " " + lastName + " " + age + " " + email + " " + gender + " " + city + " " + State;
	}

	@Override
	public int compareTo(User user) {

		if (user.getAge() - this.getAge() > 0)
			return 1;
		else if (user.getAge() - this.getAge() < 0)
			return -1;
		return 0;

	}

}
