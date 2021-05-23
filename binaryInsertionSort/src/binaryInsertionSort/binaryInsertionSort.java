package binaryInsertionSort;
//Java Program implementing binary insertion sort
import java.util.Arrays;
public class binaryInsertionSort {
	public static void main(String[] args)
	{
		final int[] arr = {37,23,0,17,12,72,31,46,100,88,54};
		new binaryInsertionSort().sort(arr);
		
		for (int i=0;i<arr.length;i++)
			System.out.println(arr[i] + " ");
	}
	
	//Driver Code
	public void sort(int array[])
	{
		for(int i = 1;i<array.length;i++)
		{
			int x = array[i];
			
			//Find location to insert using binary search
			int j = Math.abs(
				Arrays.binarySearch(array, 0, i, x) +1);
				
				//shifting array to one location right
				System.arraycopy(array,  j,  array,  j+1,  i-j);
				
				//placing element at its correct location
				array[j] = x;
			}
		}
	}

 