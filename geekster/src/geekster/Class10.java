package geekster;

public class Class10 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int s = 3;
		binarySearch(arr,s);
	}
	
	//-------------binary search-----------------------//
	
	public static void binarySearch(int[] arr,int s) {
		int start = 0;
		int end = arr.length;
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid]<s) {
				start = mid;
			}else if(arr[mid]>s) {
				end = mid;
			}else if(arr[mid] == s) {
				System.out.println(mid);
				break;
			}
		}
	}

}
