//Java Program for implementation of Bubble SOrt
class BubbleSort{
	void bubbleSort(int arr[]) {
		int n = arr.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-1;j++)
				if(arr[j]>arr[j+1])
				{
					//Swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
	}
	/* prints the array */
	void printArray(int arr[])
	{
		int n = arr.length;
		for(int i=0;i<n;i++)
			System.out.println(arr[i]+ "");
		System.out.println();
	}
//	Driver method to test above
	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		int arr[] = {64,34,25,12,22,11,90};
		obj.bubbleSort(arr);
		System.out.println("Sorted Array");
		obj.printArray(arr);
	}
}
