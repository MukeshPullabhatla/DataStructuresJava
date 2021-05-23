

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MainPart3 {
	/*
	 * Question 3: - This is a simple programming question that focuses on
	 * finding the longest increasing subarray. Given the array A =
	 * {1,2,3,2,5,2,4,6,7} the longest increasing subarray is {2,4,6,7}, note
	 * that the values have to be contiguous.
	 */
	public static List<User> usersList = new ArrayList<User>();

	private static List<User> compareList() {
		for (String user : Data.users) {
			for (String otheruser : Data.otherUsers) {
				String[] userData = user.split(",");
				if (user.equals(otheruser)) {
					User user1 = new User(userData[0], userData[1], Integer.parseInt(userData[2]), userData[3],
							userData[4], userData[5], userData[6]);
					usersList.add(user1);
					break;
				}
			}

		}
		return usersList;
	}

	public static void main(String[] args) {

		ArrayList<User> compareList = (ArrayList<User>) compareList();
		Collections.sort(compareList, new UserStateComparator());
		for (int i = 0; i < compareList.size(); i++) {
			System.out.println(compareList.get(i));
		}

	}
}
