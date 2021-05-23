import java.util.HashMap;
public class CreateHashMapExample {
	public static void main(String[] args) {
		HashMap<String, Integer> numberMapping = new HashMap<>();
		
		numberMapping.put("one", 1);
		numberMapping.put("two", 2);
		numberMapping.put("three", 3);
		
		numberMapping.putIfAbsent("four", 4);
		
		System.out.println(numberMapping);
	}

}
