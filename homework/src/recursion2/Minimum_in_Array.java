package recursion2;

public class Minimum_in_Array {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(printMax(arr,0));

	}
	public static int printMax(int[] arr,int vindex) {
		if(vindex ==  arr.length-1) {
			return arr[vindex];
		}
		int res_min = printMax(arr,vindex+1);
		if(res_min<arr[vindex]) {
			return res_min;
		}else {
			return arr[vindex];
		}
	}

}
