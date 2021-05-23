import java.util.HashMap;
import java.util.Map;

public class AccessKeysHashMapExample {
	public static void main(String[] args) {
		Map<String, String> userCityMapping = new HashMap<>();
		
		//Check if a HashMap is empty
		System.out.println("is userCityMapping empty?: " +userCityMapping.isEmpty());
		
		userCityMapping.put("john", "New York");
		userCityMapping.put("Rajeev", "Bengaluru");
		userCityMapping.put("Steve", "London");
		
		System.out.println("userCityMapping HashMap: " +userCityMapping);
		
		//Find the size of a HashMap
		System.out.println("We have the city information of " + userCityMapping.size() + "users");
		
		String userName = "Steve";
		
		//check if a key exist in a hashmap
		
		if(userCityMapping.containsKey(userName)) {
			//Get the value assigned to a given key in the HashMap
			
			String city = userCityMapping.get(userName);
			System.out.println(userName + "lives in" + city);
		}else {
			System.out.println("City details not found for the user " + userName);
		}
		
		//check if a value exists in a HashMap
		if(userCityMapping.containsValue("New York")) {
			System.out.println("There is a user in the userCItyMapping who live in New York");
		}else {
			System.out.println("There is no user in the userCityMappping who lives in New York");
		}
		
		//Modify the value assigned to an existing key
		userCityMapping.put(userName, "California");
		System.out.println(userName + "moved to a new city" + userCityMapping.get(userName) + ", New userCityMapping: " + userCityMapping);
		
		//The get() method return null if the specified key was not found in the hashmap
		System.out.println("Lisa's City: " + userCityMapping.get("Lisa"));
		
	}

}
