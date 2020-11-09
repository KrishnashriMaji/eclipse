package recursion1;

public class Increasing_decreasing {

	public static void main(String[] args) {
		int count = 5;
		increasing_decreasing(1,count);

	}
	
	public static void increasing_decreasing(int num,int count) {
		if(count == 0) {
			return;
		}
		System.out.println(num);
		increasing_decreasing(num+1,count-1);
		System.out.println(num);
		
	}

}
