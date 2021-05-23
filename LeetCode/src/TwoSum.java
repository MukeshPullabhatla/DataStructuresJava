
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j] == target-nums[i]) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
		//return null;
	}
	public static void main(String[] args) {
		int nums[] = {2,7,11,15};
		int target = 9;
		int[] result = TwoSum.twoSum(nums, target);
		System.out.println(result);
	}

}
