package class44_hashmap_build;

public class Test1 {

	public static void main(String[] args) {
		Test<String,Integer> t = new Test();
		t.put("India", 122);
		t.put("Australia", 1220);
		t.put("B", 500);
		t.put("WI", 10);
		t.put("Pak", 50);
		t.display();
		t.remove("Pak");
		t.display();

	}

}
