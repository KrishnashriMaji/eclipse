
public class Test {

	public static void main(String[] args) {
		int[] arr = {3,5,6,3,3,3,4,1,4};
		int f_num = 3;
		printAllIndices(arr,f_num,0);
	}
	
	public static void printAllIndices(int[] arr,int f_num,int count) {
		if(count == arr.length) {
			return;
		}
		printAllIndices(arr,f_num,count+1);
		 if(f_num == arr[count]) {
				System.out.println(count);
			}
	}

}
