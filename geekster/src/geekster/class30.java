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
	 
}
