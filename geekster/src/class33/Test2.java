package class33;

public class Test2 {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		Test1 t = new Test1(arr);
//		t.display();
		t.removeLeave();
		t.display();
		

	}

}