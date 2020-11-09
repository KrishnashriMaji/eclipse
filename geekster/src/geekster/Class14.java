package geekster;

public class Class14 {

	public static void main(String[] args) {
//		printDi(6);
		System.out.println(fib(5));

		int[] arr = { 2, 5, 4, 3, 2, 1, 44, 101, 2, 79 };
		
	}

	public static void printDi(int num) {
		if (num == 0) {
			return;
		}
		if (num % 2 != 0) {
			System.out.println("Hi" + num);
		}

		printDi(num - 1);

		if (num % 2 == 0) {
			System.out.println("Bye" + num);
		}
	}

	public static void printIncreasing(int num) {
		if (num == 0) {
			return;
		}
		printIncreasing(num - 1);
		System.out.println(num);
	}

	public static void printDecreasing(int num) {
		if (num == 0) {
			return;
		}
		System.out.println(num);
		printDecreasing(num - 1);
	}

	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		}
		int fnm1 = factorial(num - 1);
		int fnm = fnm1 * num;
		return fnm;
	}

	public static int power(int num, int pow) {
		if (pow == 0) {
			return 1;
		}
		return num * power(num, pow - 1);
	}

	public static int powerBtr(int num, int pow) {
		if (pow == 0) {
			return 1;
		}

		if (pow == 1) {
			return num;
		}
		int powby2 = powerBtr(num, pow / 2);
		if (pow % 2 == 0) {
			return powby2 * powby2;
		} else {
			return powby2 * powby2 * num;
		}
	}

	public static int fib(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		int fibnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		int currFib = fibnm1 + fibnm2;
		return currFib;
	}

}
