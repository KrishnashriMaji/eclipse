package geekster;

import java.util.Scanner;
import java.util.Stack;

public class class30 {

	public static void main(String[] args) {
		Stack<Integer> sc = new Stack<>();
		sc.push(1);
		sc.push(4);
		System.out.println(sc.pop());
		System.out.println(sc.peek());
		System.out.println(sc.empty());
		
		Scanner scn = new Scanner(System.in);
        String s = scn.next();
        System.out.println(validParentheses(s));
        System.out.println(scoreParentheses(s));
	}
	
	public static boolean validParentheses(String s){
        Stack<String> st = new Stack<String>();
        for(int i =0;i<s.length();i++){
            String top = s.charAt(i)+"";
            if(top.equals("(") || top.equals("{") || top.equals("[")){
                st.push(top);
            }else{
                String curChar = s.charAt(i)+"";
                if(st.empty()){
                    return false;
                }
                if(top.equals("(") && curChar.equals(")") || top.equals("{") && curChar.equals("}")  || top.equals("[") && curChar.equals("]") ){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(st.size() == 0){
            return true;
        }else{
            return false;
        }
    }
	
	
	 public static int scoreParentheses(String s){
	        Stack<String> st = new Stack<>();
	        for(int i=0;i<s.length();i++){
	            String currele = s.charAt(i)+"";
	            int t =0;
	            if(currele.equals(")")){
	                while(st.peek().charAt(0) != '('){
	                    t += Integer.parseInt(st.pop());
	                }
	                st.pop();
	                if(t == 0){
	                    st.push("1");
	                }else{
	                    st.push(Integer.toString(2*t));
	                }
	            }
	            else{
	                st.push(currele+"");
	            }
	        }
	        int ans =0;
	        while(!st.isEmpty()){
	            ans += Integer.parseInt(st.pop());
	        }
	         return ans;
	 }
	 
	 class Solution {    
		    public String longestPalindrome(String s) {    
		        if (s == null || s.isEmpty()) return s;
		        
		        int[] maxPalindromicIndexes = {0,1};
		        
				// O(n)
		        for (int i=0; i<s.length(); i++) {
				    // O(n)
		            i = checkPalindromic(s, i, maxPalindromicIndexes);
		        }
		        
				// O(n)
		        return s.substring(maxPalindromicIndexes[0], maxPalindromicIndexes[1]);
		    }
		    
		    private int checkPalindromic(String s, int start, int[] indexes) {
		        int i=start - 1;
		        int j=start + 1;
		        
//				// go to the left most of contiguouse same character for this kind of string: `abccccbk`
//				// if i is at any index of `c` initially, then shift the i pointer to left most of contiguouse 
//				// `c` character which is 1. here character at index 1 is `b` 
//		        while (i>=0 && s.charAt(i) == s.charAt(start)) {
//		            i--;
//		        }
		        
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
		    
		    private void tryToPeekMaxPalindromic(int start, int end, int[] indexes) {
		        if (end - start > indexes[1] - indexes[0]) {
		            indexes[0] = start;
		            indexes[1] = end;
		        }
		    }
		}

}
