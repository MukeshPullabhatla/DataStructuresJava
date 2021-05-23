
public class InterpolationSearch {
	public static int interpolationSearch(int arr[], int lo, int hi, int x) {
		int pos;
		if(lo<=hi && arr[lo]<=x && x<=arr[hi]) {
			pos = lo + (((hi-lo)/(arr[hi]-arr[lo]))*(x-arr[lo]));
			if(arr[pos]==x) {
				return pos; 
			}
			if(arr[pos]<x)
				return interpolationSearch(arr, pos+1, hi, x);
			if(arr[pos]>x)
				return interpolationSearch(arr, lo, pos-1,x);
			
		}
		return -1;
	}
	public static void main(String[] args) {
		int arr[] = {10,12,13,16,18,19,20,21,22,23,24,33,35,42,47};
		int n = arr.length;
		int x = 18;
		int index = interpolationSearch(arr, 0, n-1, x);
		System.out.println("for the element " + x + " the index is " + index);
	}

}
