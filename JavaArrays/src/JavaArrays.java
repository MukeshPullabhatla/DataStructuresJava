
public class JavaArrays {
	public static int javaArrays(int arr[], int n) {
		n=arr.length;
		int sum = 0;
		for(int i=0;i<n;i++) {
			
			sum += arr[i];
			
		}
		return sum;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int n = arr.length;
		int result = javaArrays(arr, n);
		System.out.println("Sum of all arrays: " + result);
	}

}
