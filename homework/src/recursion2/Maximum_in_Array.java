package recursion2;

public class Maximum_in_Array {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(printMax(arr,0));

	}
	public static int printMax(int[] arr,int vindex) {
		if(vindex ==  arr.length-1) {
			return arr[vindex];
		}
		int res_max = printMax(arr,vindex+1);
		if(res_max>arr[vindex]) {
			return res_max;
		}else {
			return arr[vindex];
		}
	}

}
