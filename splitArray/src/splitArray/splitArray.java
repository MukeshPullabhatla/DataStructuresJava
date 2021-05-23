package splitArray;

import java.util.*;
import java.lang.*;

public class splitArray{
	public static void splitArr(int arr[], int n, int k) {
		for(int i = 0; i< k; i++) {
			int x = arr[0];
			for (int j = 0; j<n-1; ++j)
				arr[j] = arr[j+1];
			arr[n-1]=x;
			
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		int n = arr.length;
		int position = 2;
		splitArr(arr, 6, position);
		for(int i = 0; i<n; ++i) {
			System.out.println(arr[i] + " ");
		}
	}
}