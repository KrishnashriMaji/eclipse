package geekster;

public class Class20_2 {
	
	public static void printPaths(int x,int y,int n,String ans){
		// base case
		if(x==n && y==n) {
			System.out.println(ans);
			return;
		}
		if(x >n || y>n) {
			return;
		}

		printPaths(x,y+1,n,ans+"H");
		printPaths(x+1,y,n,ans+"V");
		printPaths(x+1,y+1,n,ans+"D");

	}
	
	public static void printABP(int ques,int n,String ans) {
		// base case
		if(ques == n) {
			System.out.println(ans+"-"+n);
			return;
		}
		if(ques>n) {
			return;
		}

		for(int i=1;i<=6;i++) {
			printABP(ques+i,n,ans+"-"+ques);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPaths(1,1,3,"");
		
		printABP(1, 5, "");
	}

}
