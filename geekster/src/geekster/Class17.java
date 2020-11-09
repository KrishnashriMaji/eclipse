package geekster;

import java.util.ArrayList;

public class Class17 {

	public static void main(String[] args) {
		//System.out.println(getSS("abc"));
//		System.out.println(getPermutation("abc"));
		
		
//		System.out.println(getKpc("12"));
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		Integer i = 10;
//		System.out.println(i + 1);
//		int ii = 10;
		Class17 rr = new Class17();
		rr.print();
		Class17 rr1 = new Class17();
		rr1.print();
		rr.getSS("abc");
		Class17.getSS("abc");

	}
	
	public static int num1 = 10;
	public int num2  = 20;
	
	public void print() {
		System.out.println("this is non static");
		System.out.println(num1);
		System.out.println(num2);
	}
	
	public  static void print1() {
		System.out.println("this is non static");
		System.out.println(num1);
	//	System.out.println(num2);  // give error 
		
	}
	
	//----------substring of an a string------------//
	
	public static ArrayList<String> getSS(String str){
		
		if(str.length() == 0) {
			ArrayList<String> toReturn = new ArrayList<>();
			toReturn.add("");
			return toReturn;
		}
		char f_str = str.charAt(0);
		String rst = str.substring(1);
		ArrayList<String> rr = getSS(rst);
		ArrayList<String> nl = new ArrayList<>();
		for(String s:rr) {
			nl.add(s);
			nl.add(f_str + s);
		}
		return nl;
	}
	
	//----------permutation of an a string------------//
	
		public static ArrayList<String> getPermutation(String str){
			
			if(str.length() == 0) {
				ArrayList<String> toReturn = new ArrayList<>();
				toReturn.add("");
				return toReturn;
			}
			char f_str = str.charAt(0);
			String rst = str.substring(1);
			ArrayList<String> rr = getPermutation(rst);
			ArrayList<String> nl = new ArrayList<>();
			for(String s:rr) {
				for(int i=0;i<=s.length();i++) {
					String prefix = s.substring(0,i);
					String suffix = s.substring(i);
					nl.add(prefix + f_str + suffix );
				}
			}
			return nl;
		}
		
		public static ArrayList<String> getKpc(String str) {
			if (str.length() == 0) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add("");
				return temp;
			}
			char ch = str.charAt(0);
			String ros = str.substring(1);
			ArrayList<String> rr = getKpc(ros);
			ArrayList<String> mr = new ArrayList<String>();
			String mc = getChoice(ch);
			for (String s : rr) {
				for (int i = 0; i < mc.length(); i++) {
					mr.add(mc.charAt(i) + s);
				}
			}

			return mr;
		}

		public static String getChoice(char key) {
			if (key == '1') {
				return "abc";
			}
			if (key == '2') {
				return "def";
			}
			if (key == '3') {
				return "ghi";
			}
			if (key == '4') {
				return "jkl";
			}
			if (key == '5') {
				return "mno";
			}
			if (key == '6') {
				return "pqrs";
			}
			if (key == '7') {
				return "tuv";
			}
			if (key == '8') {
				return "wx";
			}
			if (key == '9') {
				return "yz";
			}
			if (key == '0') {
				return ".;";
			}
			return "";
		}

}
