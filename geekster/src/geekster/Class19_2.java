package geekster;

public class Class19_2 {
	
	public static void findAllSS(String ques,String ans) {
		// base case
		if(ques.equals("")) {
			System.out.println(ans);
			return;
		}
		// with me
		findAllSS(ques.substring(1),ans + ques.charAt(0));

		//without me
		findAllSS(ques.substring(1),ans);
		return;
	}
	
	public static void printAllP(String ques,String ans) {

		if(ques.equals("")) {
			System.out.println(ans);
			return;
		}

		for(int i=0;i<ques.length();i++) {
			String newQ = ques.substring(0,i)+ques.substring(i+1);
							//starting          //ending
			String newA = ans+ques.charAt(i);

			printAllP(newQ,newA);
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		findAllSS(s,"");
		
		String str = "abc";
		printAllP("abc","");
	}
}
