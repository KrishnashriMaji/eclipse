package class_41;

public class Test1 {
	public static void main(String[] args) {
		Test t = new Test();
//		t.add(9);
//		t.add(10);
//		t.add(40);
//		t.add(30);
//		t.add(15);
		t.add(5);
		t.add(10);
		t.add(9);
		t.add(7);
		t.add(3);
		t.add(2);
		t.display();
		System.out.println();
		t.remove();
		t.display();
		System.out.println();
		for(int i:t.kthElement(4)) {
			System.out.print(i+" ");
		}
		
	}
}
