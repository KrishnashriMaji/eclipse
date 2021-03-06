package geekster;

public class Class15 {

	public static void main(String[] args) {
//		printDi(6);
//		System.out.println(fib(5));

		int[] arr = { 2, 5, 4, 3, 2, 1, 44, 101, 2, 79 };
//		printArrayStupid(arr);
		System.out.println(findFirstIdx(arr,0,10));
//		int[] res = allIndices(arr, 0, 2, 0);
//		for (int val : res) {
//			System.out.print(val + " ");
//		}
	}


	private static void printArrayStupid(int[] arr) {
		if (arr.length == 0) {
			return;
		}
		int[] newArr = new int[arr.length - 1];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[i + 1];
		}
		System.out.print(arr[0]+" ");
		printArrayStupid(newArr);
	}

	public static void printArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		printArray(arr, vidx + 1);
	}

	static int vidx = 0;

	public static void printArrayGlobal(int[] arr) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		vidx++;
		printArrayGlobal(arr);
	}

	public static void printReverse(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		printReverse(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return arr[vidx];
		}
		int maxofRest = max(arr, vidx + 1);
		if (maxofRest > arr[vidx]) {
			return maxofRest;
		} else {
			return arr[vidx];
		}
	}

	public static boolean findStupid(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}
		boolean rr = findStupid(arr, vidx + 1, data);
		if (rr == true) {
			return true;
		} else {
			if (arr[vidx] == data) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean findSmart(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}
		if (arr[vidx] == data) {
			return true;
		}

		boolean rr = findSmart(arr, vidx + 1, data);
		return rr;

	}

	public static int findFirstIdx(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == data) {
			return vidx;
		}

		return findFirstIdx(arr, vidx + 1, data);
	}

	public static int findLastIdx(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		int rr = findLastIdx(arr, vidx + 1, data);
		if (rr != -1) {
			return rr;
		} else {
			if (arr[vidx] == data) {
				return vidx;
			} else {
				return -1;
			}
		}

	}

	public static int[] allIndices(int[] arr, int vidx, int data, int fsf) {
		if (vidx == arr.length) {
			int[] newArr = new int[fsf];
			return newArr;
		}
//		pre area
		if (arr[vidx] == data) {
			fsf++;
		}

		int[] rr = allIndices(arr, vidx + 1, data, fsf);
//		post area
		if (arr[vidx] == data) {
			rr[fsf - 1] = vidx;
		}

		return rr;

	}

}
