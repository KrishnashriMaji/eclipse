package geekster;

public class Class11 {
	
	public static void main(String[] args) {
//		int[] arr1 = { 2, 5, 7, 9, 11 };
//		int[] arr2 = { 1, 3, 7, 9, 10 };
//		int[] merged = mergeArray(arr1, arr2);
//		for (int val : merged) {
//			System.out.print(val + " ");
//		}

//		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		int val = trap(arr);
//		System.out.println(val);
		
//		int[] arr = {2,5,4,6,4,5,2};
//		findNotDouble(arr);
		
//		int[] arr = {3,3,4,2,4,4,2,4,4};
//		magorityElement(arr);
		
//		int arr[] = { 1,4,2,2,3}; 
//        int n = arr.length; 
//        missingAndRepeated(arr); 
        
        int arr[] = {3,0,1};
        missingNumber(arr);
	}
	//------------missing number-------------------//
	
	 public static void missingNumber(int[] nums) {
         int sum= nums.length*(nums.length+1)/2;
       for(int i=0;i<nums.length;i++)
           sum -= nums[i];
      System.out.println(sum);
   }
	
	//-----------------------missing and repeated number O(n)-------------------//
	
	public static void missingAndRepeated(int[] arr) {
		int i; 
        System.out.print("The repeating element is "); 
  
        for (i = 0; i < arr.length; i++) { 
            int abs_val = Math.abs(arr[i]); 
            if (arr[abs_val - 1] > 0) 
                arr[abs_val - 1] = -arr[abs_val - 1]; 
            else
                System.out.println(abs_val); 
        } 
  
        System.out.print("And the missing element is "); 
        for (i = 0; i < arr.length; i++) { 
            if (arr[i] > 0) 
                System.out.println(i + 1); 
        } 
	}
	
	//-------------------------majority element-------------------------//
	
	public static void magorityElement(int[] arr) {
		int me = arr[0];
		int count= 1;
		for(int i=1;i<arr.length;i++) {
			if(me == arr[i]) {
				count++;
			}else {
				count--;
			}
			if(count == 0) {
				count = 1;
				me= arr[i];
			}
		}
		System.out.println(me); 
	}
	
	//-----------------find not double no (special case) ---------------//
	public static void findNotDouble(int[] arr) {
		int ans = 0;
		for(int i=0;i<arr.length;i++) {
			ans = ans^arr[i];
		}
		System.out.println(ans);
		
	}

	public static int trap(int[] height) {
		if(height.length ==0) {
			return 0;
		}
		int[] lmax = new int[height.length];
		int[] rmax = new int[height.length];

		lmax[0] = height[0];

		for (int i = 1; i < height.length; i++) {
			lmax[i] = Math.max(height[i], lmax[i - 1]);
		}

		rmax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			rmax[i] = Math.max(height[i], rmax[i + 1]);
		}

		int ans = 0;

		for (int i = 1; i < height.length - 1; i++) {
			int minBoth = Math.min(lmax[i], rmax[i]);
			if (minBoth > height[i]) {
				ans += minBoth - height[i];
			}
		}

		return ans;
	}

	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int[] res = new int[arr1.length + arr2.length];

		while (p1 < arr1.length && p2 < arr2.length) {
			if (arr1[p1] < arr2[p2]) {
				res[p3] = arr1[p1];
				p1++;
			} else {
				res[p3] = arr2[p2];
				p2++;
			}
			p3++;
		}

		while (p1 < arr1.length) {
			res[p3] = arr1[p1];
			p1++;
			p3++;
		}

		while (p2 < arr2.length) {
			res[p3] = arr2[p2];
			p2++;
			p3++;
		}
		return res;
	}
	
	//---------------my approach--------------------------//

	public static int[] mergeArray(int[] arr1,int[] arr2) {
		int[] arr3 = new int[arr1.length+arr2.length];
		
		int f =0;
		int s =0;
		for(int i=0;i<arr3.length;i++) {
			if(f!=arr1.length && s !=arr2.length) {
				if(arr1[f]<arr2[s]) {
					arr3[i] = arr1[f];
					f++;
				}else {
					arr3[i] = arr2[s];
					s++;
				}
			}else if(f==arr1.length) {
				arr3[i] = arr2[s];
				s++;
			}else if(s==arr1.length) {
				arr3[i] = arr1[f];
				f++;
			}
			
		}
		
		return arr3;
	}

}
