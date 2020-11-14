package geekster;

import java.util.ArrayList;
import java.util.Stack;

public class Class33 {

	public static void main(String[] args) {
		int[] arr = {2,1,5,6,2,3};
//		System.out.println(largestRectangleArea(arr));
		
		int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		System.out.println(maximalRectangle(matrix));
	}
	
	//----------------Maximal Rectangle---------------------//
	
    public static int maximalRectangle(int[][] matrix) {
        for(int i =1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] != 0){
                	matrix[i][j] += matrix[i-1][j];
                }
            }
        }
//        for(int a =0;a<matrix.length;a++) {
//        	for(int b=0;b<matrix[a].length;b++) {
//        		System.out.print(matrix[a][b]+ " ");
//        	}
//        	System.out.println();
//        }
        int max = Integer.MIN_VALUE;;
        for(int k=0;k<matrix.length;k++){
            max = Math.max(max,largestRectangleArea(matrix[k]));
        }
        return max;
    }
    
    
	//-------------------hystogram (max area)---------------------//
	
	 public static int largestRectangleArea(int[] h) {
	        Stack<Integer> st=new Stack<>();
	        st.push(-1);
	        int maximum_area=0;
	        // 2,5,5,5,4,4,3,5
	        for(int i=0;i<h.length;i++){
	            if(st.peek()==-1||h[st.peek()]<h[i]){
	                st.push(i);
	            }else{
	                while(st.peek()!=-1&&h[st.peek()]>=h[i]){
	                    int height=h[st.pop()];
	                    int area=height*(i-st.peek()-1);
	                    maximum_area=Math.max(area,maximum_area);
	                }
	                st.push(i);
	            }
	        }
	        while(st.peek()!=-1){
	             int height=h[st.pop()];
	            int area=height*(h.length-st.peek()-1);
	            maximum_area=Math.max(area,maximum_area);

	        }
	        return maximum_area;
	    }
}
