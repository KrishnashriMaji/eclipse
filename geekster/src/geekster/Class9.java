package geekster;

import java.util.Scanner;

public class Class9 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("print size of array");
//		int size = sc.nextInt();
//		int[] arr = new int[size];
//		for(int i =0;i<arr.length;i++) {
//			arr[i] = sc.nextInt();
//		}
//		System.out.println("no of query");
//		int qu = sc.nextInt();
//		int[][] query = new int[qu][2];
//		for(int j=0;j<qu;j++) {
//			for(int k =0;k<2;k++) {
//				query[j][k]=sc.nextInt();
//			}
//		}
		
		//-------------sum between two point m times (worst case)------------------------------//
//			int[] res = new int[qu];
			
//			for(int m=0;m<query.length;m++) {
//				int sum = 0;
//				for(int q=query[m][0];q<=query[m][1];q++) {
//					sum += arr[q-1];
//				}
//				res[m] = sum;
//			}
//			for(int s:res) {
//				System.out.print(s+" ");
//			}
			
			//-----------------------------prefix sum approach-------------------------------------------//
//			int[] res = new int[qu];
//			for(int j=1;j<arr.length;j++) {
//				arr[j] = arr[j]+arr[j-1];
//			}
//			
//			for(int m=0;m<query.length;m++) {
//				//----------corner case------------//
//				
//				int start = query[m][0];
//				int end = query[m][1]-1;
//				
//				if(query[m][0] == 1) {
//					start = 0;
//					res[m] = arr[end];
//
//				}else {
//					start = start-2;
//					res[m] = arr[end]-arr[start];
//				}
//			}
//			
//			for(int s:res) {
//				System.out.print(s+" ");
//			}
			
//			int[][] quries = {{2,6,8},{3,5,7},{1,8,1},{5,9,15}};
//			int[][] quries = {{1,2,100},{2,5,100},{3,4,100}};
//			System.out.println(arrayManipulation(5,quries));
//			
//			int[] arr = {1,0,1,0,0,0,0,1,1,0};
//			int[] res = binarySorting(arr);
//			for(int s:res) {
//				System.out.print(s+" ");
//			}
			
			int[] biArr = {1,0,1,0,0,0,0,1,1,0};
			binarySorting(biArr);
	}
	
			
	
			//--------------------------------array manipulation(hacker rank)(worst case)----------------------------//
//			
//			public static long arrayManipulation(int n, int[][] queries) {
//		        int[] arr = new int[n];
//		        for(int i=0;i<queries.length;i++){
//		        	int start = queries[i][0]-1;
//		            int end = queries[i][1]-1;
//		            for(int j = start;j<=end;j++){
//		                arr[j] += queries[i][2]; 
//		            }	
//		          }
//		        
//		        return max(arr);
//
//		    }
//			public static int max(int[] arr){
//		        int max = arr[0];
//		        for(int i=1;i<arr.length;i++){
//		            if(max<arr[i]){
//		                max = arr[i];
//		            }
//		        }
//		        return max;
//		    }
//			
			//-------------------------------better approach-----------------------------------------------//
			

			public static long arrayManipulation(int n, int[][] queries) {
		        long[] arr = new long[n];
		        for(int i=0;i<queries.length;i++){
		        	
		        	int start = queries[i][0]-1;
		        	int end = queries[i][1];
		        	arr[start] += queries[i][2];
		        	 if(end<arr.length) {
		        		 arr[end] -= queries[i][2];
		        	 }
		          }
		        //----prefix sum-----//
		        for(int j=1;j<arr.length;j++) {
		        	arr[j] = arr[j]+arr[j-1];
		        }
		        
		        return max(arr);

		    }
			
			public static long max(long[] arr){
		        long max = arr[0];
		        for(int i=1;i<arr.length;i++){
		            if(max<arr[i]){
		                max = arr[i];
		            }
		        }
		        return max;
		    }
			
			//------------------------------binary sorting--------------------------------------------------//
			
			public static void binarySorting(int[] arr) {
				int left = 0;
				int right = arr.length-1;
				while(left<=right) {
					
					if(arr[left] != arr[right]) {
						int temp = arr[left];
						arr[left] = arr[right];
						arr[right] = temp;
					}
					while(arr[left] != 1) {
						left++;
					}
					while(arr[right]  != 0) {
						right--;
					}
				}
				for(int a :arr) {
					System.out.print(a+" ");
				}
				
			}

		

	

}
