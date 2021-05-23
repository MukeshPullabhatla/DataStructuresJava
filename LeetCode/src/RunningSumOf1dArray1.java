
public class RunningSumOf1dArray1 {
	public int[] runningSum(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			nums[i] += nums[i-1];
		}
		
		return nums;
	}
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6};
		RunningSumOf1dArray1 ob = new RunningSumOf1dArray1();
		int result[] = ob.runningSum(nums);
		System.out.println(result);
	}
	

}
