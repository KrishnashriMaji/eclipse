package recursion2;

public class Last_occurence {

	public static void main(String[] args) {
		int[] arr = {3,5,6,3,3,3,4,1,4};
		int f_num = 5;
		System.out.println(printLastIndex(arr,f_num,arr.length-1));
	}
	
	public static int printLastIndex(int[] arr,int f_num,int count) {
		if(count < 0) {
			return -1;
		}
		if(f_num == arr[count]) {
			return count;
		}
		return printLastIndex(arr,f_num,count-1);
	}

}
