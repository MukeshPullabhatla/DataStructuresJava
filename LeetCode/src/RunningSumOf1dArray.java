
public class RunningSumOf1dArray {
	public int[] runningSum(int[] nums) {
		
		int temp[] = new int[nums.length];
		
		for(int i = 1;i<nums.length;i++) {
			temp[i] = temp[i-1] + nums[i];
		}
		return temp;
		
	}
	public static void main(String[] args) {
		int nums[] = {1,1,1,1,1};
		RunningSumOf1dArray ob = new RunningSumOf1dArray();
		int[] result = ob.runningSum(nums);
		System.out.println(result);
	}
	

}
