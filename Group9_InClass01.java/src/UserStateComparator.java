

import java.util.Comparator;

public class UserStateComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {

		return o2.getState().compareTo(o1.getState());
	}

}
