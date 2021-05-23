
public class TernarySearch {
	public static int ternarySearch(int arr[], int l, int r, int x) {
		
		if(r>=l)
		{
			
		
		int mid1 = l + (r-l)/2;
		int mid2 = mid1 + (r-l)/2;
		
		if(arr[mid1]==x)
			return mid1;
		if(arr[mid2]==x)
			return mid2;
		if(arr[mid1]>x)
			return ternarySearch(arr, l, mid1-1, x);
		if(arr[mid2]<x)
			return ternarySearch(arr, mid2+1, r, x);
		return ternarySearch(arr, mid1+1, mid2-1, x);
	}
	return -1;
}
	
	public static void main(String[] args) {
		int arr[] = {1,2,4,8,10,16,21,45,55,100,120,151,201,488,500};
		int n = arr.length;
		int x = 100;
		int result = ternarySearch(arr, 0, n-1, x);
		if(result == -1)
			System.out.println("Element is not present in the array");
		else
			System.out.println("Element is present at index: " + result);
	}
}

