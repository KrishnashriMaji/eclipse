package recursion1;

public class Fibonacci {

	public static void main(String[] args) {
		int num = 8;
		int n1 = 0;
		int n2 = 1;
		System.out.print(n1 +" "+n2);
       fibonacci(num-2,0,1);
	}
	
	 static void fibonacci(int count,int n1,int n2){    
	    if(count>0){    
	         int n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         fibonacci(count-1,n1,n2);    
	     }    
	 }    

}
