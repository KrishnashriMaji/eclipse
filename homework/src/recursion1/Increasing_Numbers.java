package recursion1;

public class Increasing_Numbers {

	public static void main(String[] args) {
		int num  = 5;
		increasing(num);

	}
	public static void increasing(int num) {
		if(num == 0) {
			return;
		}
		increasing(num-1);
		System.out.println(num);
		
	}

}
