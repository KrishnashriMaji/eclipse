package class43_hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
//		highestFrequenceyCharacter("geekster");

		int[] one = { 5, 1, 3, 1, 2, 2, 1 };
		int[] two = { 2, 2, 4, 1, 1, 5, 2 };
		getCommonElements2(one, two);

	}
	
	public static void getCommonElements2(int[] arr1,int[] arr2) {
		HashMap<Integer,Integer> hasMap = new HashMap<>();
		for(int i =0;i<arr1.length;i++) {
			hasMap.put(arr1[i], hasMap.getOrDefault(arr1[i], 0)+1);
		}
		
		for(int j:arr2) {
			if(hasMap.containsKey(j)) {
				System.out.println(j);
				hasMap.put(j, hasMap.get(j)-1);
				
				if(hasMap.containsKey(j)) {
					if( hasMap.get(j) == 0) {
						hasMap.remove(j);
					}
				}
				
			}
		}
	}

}
