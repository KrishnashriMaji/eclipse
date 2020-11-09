package geekster;

public class Class21 {

	public static void main(String[] args) {
//		System.out.println(getKpc("12"));
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		Integer i = 10;
//		System.out.println(i + 1);
//		int ii = 10;
//		RecursionContd rr = new RecursionContd();
//		rr.print();
//		RecursionContd rr1 = new RecursionContd();
//		rr1.print();
//		rr.getSS("abc");
//		RecursionContd.getSS("abc");
//		int[][] boards = new int[4][4];
//		nQueens(boards, "", 0);
//		int[] arr = { 3, 34, 4, 12, 5, 2 };
//		subsetSum(arr, 0, 0, 9, "");
		subset("abc", "");
	}

	public static void subset(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		subset(ros, ans);
		subset(ros, ans + ch);
	}

	public static void subsetSum(int[] arr, int vidx, int currSum, int target, String ans) {
		if (vidx == arr.length) {
			if (currSum == target) {
				System.out.println(ans);
			}
			return;
		}

//		if all elements are positive
		if (currSum > target) {
			return;
		}
		subsetSum(arr, vidx + 1, currSum + arr[vidx], target, ans + arr[vidx] + " ");
		subsetSum(arr, vidx + 1, currSum, target, ans);
	}

	public static void subsetSum2(int[] arr, int vidx, int target, String ans) {
		if (vidx == arr.length) {
			if (target == 0) {
				System.out.println(ans);
			}
			return;
		}

//		if all elements are positive
		if (target < 0) {
			return;
		}
		subsetSum2(arr, vidx + 1, target - arr[vidx], ans + arr[vidx] + " ");
		subsetSum2(arr, vidx + 1, target, ans);
	}

	public static void nQueens(int[][] board, String ans, int qsf) {
		if (qsf == board.length) {
			System.out.println(ans);
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			if (isItSafe(board, qsf, col) == true) {
				board[qsf][col] = 1;
				nQueens(board, ans + "R" + qsf + "C" + col + " ", qsf + 1);
				board[qsf][col] = 0;
			}
		}
	}

	private static boolean isItSafe(int[][] board, int row, int col) {
//		vertical Position
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}

//		first Diagonal
		int i = row - 1;
		int j = col - 1;
		while (i >= 0 && j >= 0) {
			if (board[i][j] == 1) {
				return false;
			}
			i--;
			j--;
		}

//		second Diagonal
		i = row - 1;
		j = col + 1;
		while (i >= 0 && j < board[0].length) {
			if (board[i][j] == 1) {
				return false;
			}
			i--;
			j++;
		}

		return true;

	}

	public static int num = 10;
	public int num2 = 20;

	public void print() {

		System.out.println("Hello Non Static");
	}

}
