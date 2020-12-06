package test_15_11_20;
import java.util.*;

//--------------  https://www.hackerrank.com/contests/geekster-weekly-assessment-1605339278/challenges  -------------------//

public class RemoveDuplicate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = checkAndRemove(s);
        if(res.length() == 0){
            System.out.println("VANISHED");
        }else{
            System.out.println(res);
        }
	}
	
	public static String checkAndRemove(String str) {
		if(str.length() == 1) {
			return str;
		}
		for(int i=0;i<str.length()-1;i++) {
			String current = str.charAt(i)+"";
			if(str.charAt(i) == str.charAt(i+1)) {
				str = str.replace(current,"");
				return checkAndRemove(str);
			}
		}
		return str;
	}

}
