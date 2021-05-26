
public class ShuffleTheArray {
	public static int[] shuffle(int[] nums, int n) {
		int[] result = new int[2*n];
		int counter = 0;
		for(int i=0;i<n;i++) {
			result[counter] = nums[i];
			result[counter+1] = nums[n+i];
			counter+=2;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ShuffleTheArray ob = new ShuffleTheArray();
		int nums[] = {1,1,2,2};
		int n = nums.length;
		int[] result = ob.shuffle(nums, n);
		System.out.println(result);
		
		
		
	}

	

}
