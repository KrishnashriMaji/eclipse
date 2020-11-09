package geekster;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
	int[] arr = {1,2,3,4,5};
	targetArr(arr,4);

	}
	
	public static void targetArr(int[] arr,int target) {
		int left = 0;
		int right = arr.length-1;
		while(left != right) {
			if(arr[left]+arr[right] == target) {
				System.out.println(left+" "+right);
				break;
			}else if(arr[left]+arr[right]< target){
				left++;
			}else {
				right--;
			}
		}
	}
	
			
}
