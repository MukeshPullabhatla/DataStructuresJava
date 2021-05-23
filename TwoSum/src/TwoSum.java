public class TwoSum{
	public static int[] twoSum(int arr[], int target) {
		int n = arr.length;
		
		for(int i = 0;i<n-1;i++) {
			for(int j = 0;j<n;j++) {
				if(arr[j]==target-arr[i]) {
					return new int[]{i,j};
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		TwoSum ob = new TwoSum();
		int arr[] = {2,7,11,15};
		int target = 9;
		int[] result = ob.twoSum(arr, target);
		System.out.println(result);
	}
}