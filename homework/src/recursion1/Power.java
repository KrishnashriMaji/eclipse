package recursion1;

public class Power {

	public static void main(String[] args) {
		int num = 3;
		int power = 4;
		System.out.println(power(num,power));

	}
	public static int power(int num,int power) {
		if(power==1) {
			return num;
		}
		
		int powby2 =  power(num,power/2);
		if(power%2==0) {
			return powby2*powby2;
		}else {
			return powby2*powby2*num;
		}
	}

}
