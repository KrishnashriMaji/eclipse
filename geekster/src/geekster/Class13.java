package geekster;

import java.util.Arrays;

public class Class13 {

	public static void main(String[] args) {
		int[] arr = {5,2,3,9,5,8};
//		selectionSort(arr);
//		bubbleSort(arr);
//		insertionSort(arr);
		
		Arrays.sort(arr);
//		for(int a:arr) {
//        	System.out.print(a+" ");
//        }
		 findSum(arr,12);
	}
	
	//----------------------find sum between two element--------------------//
	
	public static void findSum(int[] arr,int sum) {
		boolean hasSum  = false;
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			if(arr[start]+arr[end] == sum) {
				hasSum = true;
				break;
			}else if(arr[start]+arr[end]>sum) {
				end--;
			}else if(arr[start]+arr[end]<sum) {
				start++;
			}
		} 
		System.out.println(hasSum);
		
	}
	
	//------------------------selection sort----------------------//
	
	public static void selectionSort(int[] arr) {

		int n = arr.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        
        for(int a:arr) {
        	System.out.print(a+" ");
        }
	}
	
	public static void bubbleSort(int[] arr) {

		int n = arr.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                	  // Swap the next element with the first
                    // element
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        }
        
        for(int a:arr) {
        	System.out.print(a+" ");
        }
	}
	
	public static void insertionSort(int[] arr) {

		int n = arr.length;
        for (int i = 1; i < n; i++)
        {
        	int j = i;
            while(j != 0 && arr[j-1]>arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        
        for(int a:arr) {
        	System.out.print(a+" ");
        }
  }
}
