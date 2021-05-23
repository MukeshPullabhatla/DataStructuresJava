import java.util.Map;
import java.util.HashMap;;
public class TwoSum1 {
	public static int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int complement = target-nums[i];
			if(map.containsKey(complement)) {
				//int toReturn[] = {map.get(diff), i};
				//return toReturn;
				return new int[] {i, map.get(complement)};
				//return new int[]{map.get(complement),i};
				}
				map.put(nums[i],i);
			}
			return null;
			
		}
	public static void main(String[] args) {
		int nums[] = {2,7,11,15};
		int target = 9;
		int[] result = TwoSum1.twoSum1(nums, target);
		System.out.println(result);
	}
	}