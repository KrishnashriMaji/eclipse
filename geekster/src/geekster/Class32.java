package geekster;

import java.util.ArrayList;
import java.util.Stack;

public class Class32 {

	public static void main(String[] args) {
		
		//-------------immediate smallest number----------------------//
		
		int[] arr = {1,10,5,2,1,100,200,500,150};
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0;i<arr.length;i++) {
			while(!st.isEmpty() && st.peek() >= arr[i]) {
				st.pop();
			}
			int sol = -1;
			if(!st.isEmpty()) {
				sol = st.peek();
			}
			list.add(sol);
			st.add(arr[i]);
		}
		System.out.println(list);

	}

}
