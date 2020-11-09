package recursion2;

public class FInd_any_index {

	public static void main(String[] args) {
		int[] arr = {5,6,3,3,3,4,1,3,4};
		int f_num = 3;
		System.out.println(printCountValue(arr,f_num,0));
	}
	public static int printCountValue(int[] arr,int f_num,int vindex) {
		if(vindex == arr.length) {
			return 0;
		}
		int res_count = printCountValue(arr,f_num,vindex+1);
		if(f_num == arr[vindex]) {
			res_count++;
		}
		return res_count;
	}

}
