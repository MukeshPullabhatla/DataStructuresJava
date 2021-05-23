
public class BinaryIterativeSearch {
	int binarySearch(int arr[], int x){
		int l=0, r = arr.length-1;
		while(l<=r) {
			int m = l+(r-1)/2;
			if(arr[m]==x) 
				return m;
			if(arr[m]<x)
				l = m+1;
			else
				r=m-1;
		}
		return -1;
	}
	public static void main(String[] args) {
		BinaryIterativeSearch obj = new BinaryIterativeSearch();
		int arr[] = {2,4,6,8,10,12,14,16,18,20};
		int n = arr.length;
		int x = 10;
		int result = obj.binarySearch(arr,x);
		if(result == -1)
			System.out.println("element is not present");
		else
			System.out.println("element is present at" + "index" +result);
				
	}

}
