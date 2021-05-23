package linearsearch;

//java implementation of linear search
public class linearsearch {
	//linearly search x in array[]. if x is present then
	//return the index, otherwise return -1
	public static int search(int arr[], int n, int x) {
		int i;
		for(i=0;i<n;i++) {
			if(arr[i]==x) {
				return i;
			}
		}
		return -1;
		
	}
	//Driver program to test above funtions
	public static void main(String[] args) {
		int arr[] = {1,10,30,15};
		int x = 30;
		int n = arr.length;
		System.out.printf("%d is present at index %d", x, search(arr,n,x));
	}

}
