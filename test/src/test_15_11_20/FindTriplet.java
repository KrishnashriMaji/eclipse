package test_15_11_20;
import java.util.*;
//------------------ https://www.hackerrank.com/contests/geekster-weekly-assessment-1605339278/challenges/find-those-triples --------//

public class FindTriplet {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
//		 Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int diff = sc.nextInt();
//        int[] arr = new int[size];
//        for(int i=0;i<size;i++){
//            arr[i] = sc.nextInt();
//        }
//        
//        findTriplet(arr,diff);
	}
	public static void findTriplet(int[] arr,int diff) {
		int start = 0;
		int end = 0;
		int sum = 0;
		while(end<arr.length) {
			if(arr[end] - arr[start] >= diff) {
				int n = end-start-1;
				sum += fact(n)/(fact(2)*fact(n-2));
				System.out.println(sum);
				start++;
			}else {
				end++;
			}
		}
		System.out.println(sum);
	}
	public static int fact(int num) {
		return 0;
	}

}
