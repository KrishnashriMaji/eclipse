package geekster;
public class Class24 {
	public static void main(String[] args) {
		int[] denomination = {1,5,7,10,15};
		int num = 10;
		System.out.println(foo(num,denomination,0));
		System.out.println(foo1(10,denomination));
		
		int[] length = {1,3,7,10};
		int[] price = {2,5,10,25};
		System.out.println(cutRod(13,price,length));
		
	}
	
	 // -------no of posibility among amount -------------// 
		public static int foo(int ruppee,int[] deno,int index) {
			//base case
			if(ruppee == 0) {
				return 1;
			}
			if(ruppee < 0) {
				return 0;
			}
			int count = 0;
			for(int i=index;i<deno.length;i++) {
				count += foo(ruppee-deno[i],deno,i);
			}
			return count;
		}
		
		//--------min no of amount --------------//
		public static int foo1(int ruppee,int[] deno) {
			//base case
			if(ruppee == 0) {
				return 0;
			}
			
			if(ruppee < 0) {
				return 100000002;
			}
			
			int mincoin = 100000002; // taking largest no asuming
			for(int i=0;i<deno.length;i++) {
				mincoin = Math.min(mincoin,foo1(ruppee-deno[i],deno));
			}
			return mincoin+1;
		}
		
		//--------------rod cutting---------//
		
		public static int cutRod(int n,int price[],int lengths[])
		{
			if (n <= 0)
				return 0;
			int max_val = Integer.MIN_VALUE;
			// Recursively cut the rod in different pieces and compare different 
			//configurations
			for (int i = 0; i<lengths.length; i++) {
				if(lengths[i]<=n)
					max_val = Math.max(max_val,price[i]+cutRod(n-lengths[i],price,lengths));
			}
			return max_val;
		}

}
