package recursion2;

public class Print_array {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		printArr(arr,arr.length-1);

	}
	public static void printArr(int[] arr,int len) {
		if(len< 0) {
			return;
		}
		printArr(arr,len-1);
		System.out.print(arr[len]);
	}

}