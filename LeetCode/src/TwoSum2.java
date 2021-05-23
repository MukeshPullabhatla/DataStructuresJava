import java.util.Map;
import java.util.HashMap;

public class TwoSum2 {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		for(int i=0;i<nums.length;i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
			
	}
	public static void main(String[] args) {
		int nums[] = {2,7,11,15};
		int target = 9;
		int[] result = TwoSum2.twoSum(nums, target);
		System.out.println(result);
	}

}
