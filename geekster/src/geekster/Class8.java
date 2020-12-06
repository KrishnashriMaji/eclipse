package geekster;

public class Class8 {

	public static void main(String[] args) {
		
//		Scanner scn = new Scanner(System.in);
//		int[] arr = new int[5];
//		int val = 5;
//		fun(val);
//		System.out.println(arr[3]);
//		System.out.println(val);
//		System.out.println(arr);
//		val = 10;
//		bizz(val);
		
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
//		int[] arr = {-2,-1,-3};
		System.out.println(maxsubArray(arr));

	}
	
	//-------------heap and stack in memory--------------------//
	
	public static void fun(int val) {
		int[] arr = new int[5];
		arr[2] = 15;
		System.out.println(arr[2]);
		arr = new int[10];
		System.out.println(arr[2]);
	}
	
	//---------------------------maximum sub array(kadanc's algorithm)-----------------//
	
	public static int maxSubArray(int[] num) {
		int curSum = 0;
		boolean onePos = false;
		int max = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<num.length;i++) {
			curSum += num[i];
			if(curSum<0) {
				curSum = 0;
			}
			if(num[i]>0) {
				onePos = true;
			}
			maxSum = Math.max(curSum, maxSum);
			max = Math.max(max, num[i]);
		}
		
		if(onePos == false) {
			return max;
		}else {
			return maxSum;
		}
	
	}
	
	//-----------------------------(prefix sum method)-------------------------------//
	
//    public static int maxSubArray(int[] nums) {
//        for(int i=1;i<nums.length;i++){
//            nums[i] = nums[i]+nums[i-1];
//        }
//        int minPrefix = 0;
//        int maxSum =Integer.MIN_VALUE;
//         for(int j=0;j<nums.length;j++){
//            maxSum = Math.max(maxSum,nums[j]-minPrefix);
//             minPrefix= Math.min(minPrefix,nums[j]);
//        }
//        return maxSum;
//    }
	
	
	public static int maxsubArray(int[] num) {
		int[] preSum = new int[num.length];
		for(int i = 1;i<num.length;i++) {
			preSum[i] = num[i]+num[i-1];
		}
		int minPre = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int j=0;j<preSum.length;j++) {
			maxSum = Math.max(maxSum, preSum[j]-minPre);
			minPre = Math.min(minPre,preSum[j]);
		}
		return maxSum;
	}
	
	
	
	
	
	

}
