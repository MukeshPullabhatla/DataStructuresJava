

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainPart2 {
	/*
	 * Question 2: - In this question you will use the Data.users array that
	 * includes a list of users. Formatted as :
	 * firstname,lastname,age,email,gender,city,state - Create a User class that
	 * should parse all the parameters for each user. - The goal is to count the
	 * number of users living each state. - Print out the list of State, Count
	 * order in ascending order by count.
	 */
	public static List<User> usersList = new ArrayList<User>();
	public static List<String> stateList = new ArrayList<String>();

	public static void populateUserList(String[] stringArray) {

		for (String userString : stringArray) {
			// System.out.println(userString);
			String[] userData = userString.split(",");
			User user = new User(userData[0], userData[1], Integer.parseInt(userData[2]), userData[3], userData[4],
					userData[5], userData[6]);
			usersList.add(user);
			stateList.add(userData[6]);

		}
	}

	public static void main(String[] args) {
		/*
		 * //example on how to access the Data.users array. for (String str :
		 * Data.users) { System.out.println(str); }
		 */

		populateUserList(Data.users);
		Map<String, Integer> stateCount = new HashMap<String, Integer>();
		for (String state : stateList) {
			if (stateCount.containsKey(state)) {
				stateCount.put(state, stateCount.get(state) + 1);
			} else {
				stateCount.put(state, 1);
			}
		}
		/*
		 * for (Map.Entry<String, Integer> entry : stateCount.entrySet()) {
		 * String stateValue = entry.getKey(); int count = entry.getValue();
		 * System.out.println("State----> " + stateValue + " Count----> " +
		 * count); }
		 */ stateCount.entrySet().stream().sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue()))
				.forEach(k -> System.out.println(k.getKey() + " ----> " + k.getValue()));
	}
}
