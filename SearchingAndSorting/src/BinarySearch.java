//Java Implementation of recursive Binary search
public class BinarySearch {
	//Returns index of x if it is present in arr[1...r]
	//else return -1
	int BinarySearch(int arr[], int l, int r, int x) {
		if(r>=l) {
			int mid = l+(r-l)/2;
			//if the element is present at the middle itself
			if(arr[mid]==x)
				return mid;
			//if element is smaller than mid, then
			//it can only be present in left subarray
			if(arr[mid]>x)
				return BinarySearch(arr,l,mid-1,x);
			//Else the element can only be present in 
			//right subarray
			return BinarySearch(arr,mid+1,r,x);
		}
		//we reach here when element is not present in array
		return -1;
	}
	//Driver method to test above
	public static void main(String[] args) {
		BinarySearch obj = new BinarySearch();
		int arr[] = {2,3,4,10,40};
		int n = arr.length;
		int x  = 10;
		int result = obj.BinarySearch(arr, 0, n-1, x);
		if (result==-1)
			System.out.println("element not present");
		else
			System.out.println("elemenet present at index" +result);
	}

}
