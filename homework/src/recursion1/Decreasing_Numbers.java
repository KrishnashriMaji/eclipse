package recursion1;

public class Decreasing_Numbers {

	public static void main(String[] args) {
		int num  = 5;
		decreasing(num);

	}
	public static void decreasing(int num) {
		if(num == 0) {
			return;
		}
		System.out.println(num);
		decreasing(num-1);
		
	}

}
