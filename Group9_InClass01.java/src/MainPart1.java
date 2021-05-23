

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPart1 {
	/*
	 * Question 1: - In this question you will use the Data.users array that
	 * includes a list of users. Formatted as :
	 * firstname,lastname,age,email,gender,city,state - Create a User class that
	 * should parse all the parameters for each user. - Insert each of the users
	 * in a list. - Print out the TOP 10 oldest users.
	 */
	public static List<User> usersList = new ArrayList<User>();

	public static void populateUserList(String[] stringArray) {

		for (String userString : stringArray) {
			// System.out.println(userString);
			String[] userData = userString.split(",");
			User user = new User(userData[0], userData[1], Integer.parseInt(userData[2]), userData[3], userData[4],
					userData[5], userData[6]);
			/*
			 * user.setFirstName(userData[0]); user.setLastName(userData[1]);
			 * user.setAge(Integer.parseInt(userData[2]));
			 * user.setEmail(userData[3]); user.setGender(userData[4]);
			 * user.setCity(userData[5]); user.setState(userData[6]);
			 */
			usersList.add(user);
		}
	}

	public static void main(String[] args) {

		// example on how to access the Data.users array.
		/*
		 * for (String str : Data.users) { System.out.println(str); }
		 */
		populateUserList(Data.users);
		Collections.sort(usersList);
		for (int i = 0; i < 10; i++) {
			System.out.println(usersList.get(i));
		}

	}
}