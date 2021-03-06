package test_08_11_20;

import java.util.Scanner;

public class LongestPalindrom {

	public static void main(String[] args) {
		String st = "forgeeksskeegfor";
		System.out.println(longestPalindrome(st).length());
		System.out.println(longestPalindrome(st));
	}
	
	public static String longestPalindrome(String s) {    
        if (s == null || s.isEmpty()) {
        	return s;
        }
        
        int[] maxPalindromicIndexes = {0,1};
        
        for (int i=0; i<s.length(); i++) {
		    // O(n)
            i = checkPalindromic(s, i, maxPalindromicIndexes);
        }
        
		// O(n)
        return s.substring(maxPalindromicIndexes[0], maxPalindromicIndexes[1]);
    }
    
    private static int checkPalindromic(String s, int start, int[] indexes) {
        int i=start - 1;
        int j=start + 1;
        
//		// go to the left most of contiguouse same character for this kind of string: `abccccbk`
//		// if i is at any index of `c` initially, then shift the i pointer to left most of contiguouse 
//		// `c` character which is 1. here character at index 1 is `b` 
//        while (i>=0 && s.charAt(i) == s.charAt(start)) {
//            i--;
//        }
        
		// go to the right most of contiguouse same character for this kind of string: `abccccbk`
		// if j is at any index of `c` initially, then shift the j pointer to right most of contiguouse 
		// `c` character which is 6. here character at index 6 is `b`
        while (j<s.length() && s.charAt(start) == s.charAt(j)) {
            j++;
        }
		// suppose we are at first `c`, that means `start` is at 2. above while loop will change j to 6.
		// so, for every `start` with value 2, 3 and 4, the j will always be shifted to 6.
		// we can tell the caller of `checkPalindromic` method to skip these redundant tasks.
		// so, we will return the right most index of contiguouse same character to the caller, 
		// in this case which is j-1 = 5. we keep the track of j into `start`, as `start` variable will not 
		// change further from here. when we return the `start` variable, we will subtract 1 from it.
		
        start = j;
        
		// normal palindrom check with two pointer
        while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
		
		// check if this i and j window is the longest or not, if yes, store the pointers
        tryToPeekMaxPalindromic(i+1, j, indexes);
		
        return start-1;
    }
    
    private static void tryToPeekMaxPalindromic(int start, int end, int[] indexes) {
        if (end - start > indexes[1] - indexes[0]) {
            indexes[0] = start;
            indexes[1] = end;
        }
    }


}
