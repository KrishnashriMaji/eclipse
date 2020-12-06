package test_22_11_20;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
//        permutation(arr);
        majorityElement(arr);

	}
	
	public static void majorityElement(int[] nums){
        // int start = 0;
        // int end = 0;
        // int max= 0;
        // int cur = 0;
        // Arrays.sort(arr);
        // while(end != arr.size){
        //     if(arr[start] == arr[end]){
        //         cur++;
        //         end++;
        //     }else{
        //         if(cur == max){
        //             max = 0
        //         }
        //         cur = 0;
        //         start = end;
        //         end= end+1;
        //     }
        //     max = Math.max(max,cur);
        // }
        
        int me = nums[0];
        int count= 1;
        for(int i=1;i<nums.length;i++) {
            if(me == nums[i]) {
                count++;
            }else {
                count--;
            }
            if(count == 0) {
                count = 1;
                me= nums[i];
                System.out.println(me);
            }
        }
//        return me;
         if(count == 1){
             System.out.println("NO MAJORITY ELEMENT");
         }else{
             System.out.println(me);
         }
    }
	
	public static void permutation(int[] arr) {
		String sw = "";
        for(int a:arr){
            sw = sw+a;
        }
        System.out.println(sw);
        ArrayList<String> rr = getPermutation(sw);
		int large = Integer.MIN_VALUE;
		boolean hasValue = false;
		for(String s:rr) {
			System.out.println(s);
			if(Integer.parseInt(s)%30 == 0) {
				large = Math.max(large,Integer.parseInt(s));
				System.out.println(large);
				hasValue = true;
			}
		}
		if(hasValue) {
			System.out.println(large);
		}else {
			System.out.println("NO NUMBER");
		}
	}
	private static ArrayList<String> getPermutation(String str){
		
		if(str.length() == 0) {
			ArrayList<String> toReturn = new ArrayList<>();
			toReturn.add("");
			return toReturn;
		}
		char f_str = str.charAt(0);
		String rst = str.substring(1);
		ArrayList<String> rr = getPermutation(rst);
		ArrayList<String> nl = new ArrayList<>();
		for(String s:rr) {
			for(int i=0;i<=s.length();i++) {
				String prefix = s.substring(0,i);
				String suffix = s.substring(i);
				nl.add(prefix + f_str + suffix );
			}
		}
		return nl;
	}

}
