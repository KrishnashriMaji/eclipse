package class31;

public class Test1 {

	public static void main(String[] args) throws Exception {
		Test ts = new Test(5);
		ts.enque(1);
		ts.enque(2);
		ts.enque(3);
		ts.enque(4);
		ts.enque(5);
//		ts.display();
		System.out.println(ts.deque());
		System.out.println(ts.deque());
		ts.enque(6);
		ts.enque(7);
		ts.enque(7);
		ts.display();
//		System.out.println(ts.size());
//		System.out.println(ts.font());

	}

}
