package class25_29;

import class25_29.Linklist;

public class Showresult {

	public static void main(String[] args) {
		Linklist list = new Linklist();
//		list.addLast(5);
//		list.addLast(10);
//		list.addLast(15);
//		list.display();
//		list.addFirst(3);
//		list.addFirst(1);
//		list.display();
//		list.addAt(7, 3);
//		list.display();
//		list.removeFirst();
//		list.display();
	//	list.removeLast();
	//	list.display();
	//	list.removeAtIndex(2);
	//	list.display();
	//	System.out.println(list.isEmpty());
	//	System.out.println(list.getSize());
	//	list.reverseDI();
		//list.display();
//		list.reversePI();
//		list.display();
		
		list.addLast(15);
		list.addLast(110);
//		list.addLast(15);
		list.addLast(11);
		list.addLast(110);
		list.addLast(5);
//		System.out.println(list.isPalindrom());
		list.reverse1();
		list.display();
		
//------------------------------------------class 28-------------------------------------------//
		
		System.out.println(list.mid());
//		System.out.println(list.kFromLast(2));
//		list.fold();
//		list.fold2();
//		list.reverseDS();
//		list.display();
		
//------------------------------------------class 29-------------------------------------------//		
		Linklist l1 = new Linklist();
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		l1.addLast(4);
		l1.addLast(5);
		Linklist l2 = new Linklist();
		l2.addLast(2);
		l2.addLast(4);
		l2.addLast(5);
		l2.addLast(6);
		l2.addLast(7);
		l2.addLast(8);
		//System.out.println(list.mergeTwoSortedLists(l1,l2)); // error
		//System.out.println(mergeTwoSortedList2(l1,l2)); // error
		//list.removeDuplicates();
//		 list.oddEvenSeperation();
//		Linklist.makeCycle(list);
//		System.out.println(Linklist.isCycle(list));
//		list.reversePR();
//		list.display();
		
		
		
		
	}
	
	public static Linklist mergeTwoSortedList2(Linklist l1,Linklist l2){
		Linklist res = new Linklist();
		while(l1.getSize()>0 && l2.getSize()>0) {
			int val1 = l1.getFirst();
			int val2 = l2.getFirst();
			if(val1<val2) {
				res.addLast(val1);
				l1.removeFirst();
			}else {
				res.addLast(val2);
				l2.removeFirst();
			}
		}
		while(l1.getSize()>0) {
			int val1 = l1.getFirst();
			res.addLast(val1);
			l1.removeFirst();
		}
		while(l2.getSize()>0) {
			int val2 = l2.getFirst();
			res.addLast(val2);
			l2.removeFirst();
		}
		return res;
	}

}