package class25_29;

import class25_29.Linklist;
import class25_29.Linklist.Helper;
import class25_29.Linklist.Node;

public class Linklist {
	class Node{
		int data;
		Node next;
	}
	Node head;
	int size;
	Node tail;
	
	public void addLast(int d) {
		Node newnode = new Node();
		newnode.data = d;
		if(size == 0) {
			head = newnode;
			tail = newnode;
		}else {
			tail.next = newnode;
			tail = newnode;
		}
		size++;
	}
	
	public void addLastNode(Node list) {
		if(this.size ==0) {
			this.head 	= 	list;
			this.tail 	= 	list;
		}else if(this.size>0){
			this.head.next	=	list.next;
			this.head.data	=	list.data;
			this.tail.next 	= 	null;
		}
		size++;
	}
	
	public void addFirst(int d) {
		Node newnode = new Node();
		newnode.data = d;
		if(size == 0) {
			head = newnode;
			tail = newnode;
		}else {
			newnode.next = head;
			head = newnode;
		}
		size++;
	}

	public void addAt(int d,int pos) {
		
		if(pos <0 || pos > size) {
			System.out.println("out of size");
			return;
		}else if(pos == 0){
			addFirst(d);
		}else if(pos == size-1) {
			addLast(d);
		}else {
			Node temp 		= head;
			int currentPos 	= 0;
			while(currentPos<pos-1) {
				temp 	= temp.next;
				currentPos++;
			}
			Node newnode = new Node();
			newnode.data 	= d;
			newnode.next 	= temp.next;
			temp.next 		= newnode;
		}
		
		size++;
	}
	
	public void removeFirst() {
		if(size == 1) {
			head = null;
			tail = null;
			size--;
		}else if(size > 0) {
			 head = head.next;
			 size--;
		}else {
			System.out.println("nothing to remove");
		}
	}
	
	public Node removeFirstNode() {
		if(size ==0) {
			return null;
		}
		Node first_n = null;
		if(size ==1) {
			first_n = head;
			head = null;
			tail = null;
		}
		if(size > 1) {
			first_n = head;
			head = head.next.next;
		}
		size--;
		return first_n;
	}
	
	public void removeLast() {
		if(size == 0) {
			System.out.println("nothing to remove");
		}else if(size == 1) {
			head = null;
			tail = null;
			size--;
		}else{
			Node temp 		= head;
			int currentPos 	= 0;
			while(currentPos<size-2) {
				temp 	= temp.next;
				currentPos++;
			}
			temp.next = null;
			tail = temp;
			size--;
		}
		
	}
	
	private void removeAt(int pos) {
		
		if(pos <1 || pos > size) {
			System.out.println("out of size");
			return;
		}else if(pos == 1){
			removeFirst();
		}else if(pos == size) {
			removeLast();
		}else {
			Node temp 		= head;
			int currentPos 	= 0;
			while(currentPos<pos-2) {
				temp 	= temp.next;
				currentPos++;
			}
			temp.next = temp.next.next;
			size--;
		}
	}
	public void removeAtIndex(int idx) {
		removeAt(idx+1);
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public void display() {
		Node temp = head;
		while(temp!= null) {
			System.out.print (temp.data + "--->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public int getFirst() {
		if(this.size == 0) {
			return -1;
		}
		return this.head.data;
	}
	
	public int getLast() {
		if(this.size == 0) {
			return -1;
		}
		return this.tail.data;
	}
	
	public int getAt(int index) {
		if(index > this.size || index< 0) {
			return -1;
		}
		Node temp = head;
		int counter = 0;
		while(counter<index) {
			temp= temp.next;
			counter++;
		}
		return temp.data;
	}
	
	public Node getNodeAt(int index) {
		if(index > this.size || index< 0) {
			return null;
		}
		Node temp = head;
		int counter = 0;
		while(counter<index) {
			temp= temp.next;
			counter++;
		}
		return temp;
	}
	
	//-------------------------class 27-------------------------------//
	
	public void reverseDI() {
		int first = 0;
		int last = size-1;
		while(first<last) {
			Node fNode= getNodeAt(first);
			Node lNode= getNodeAt(last);
			
			int temp = fNode.data;
			fNode.data = lNode.data;
			lNode.data = temp;
			first++;
			last--;
		}
	}
	
	public void reversePI() {
		Node pre = null;
		Node current = this.head;
		while(current != null) {
			Node temp = current.next;
			current.next=pre;
			pre = current;
			current = temp;
		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}
	
	class Helper{
		Node left;
	}
	public void reverse1() {
		Helper hp = new Helper();
		hp.left = head;
		Node right = head;
		isReverseHelper(hp,right,0);
	}
	public void isReverseHelper(Helper hp,Node right,int level) {
		if(right == null) {
			return;
		}
		isReverseHelper(hp,right.next,level++);
		if(level < size/2) {
			int temp = hp.left.data;
			hp.left.data = right.data;
			right.data = temp;
			
			hp.left = hp.left.next;
		}
	}
	public boolean isPalindrom() {
		Helper hp = new Helper();
		hp.left = head;
		Node right = head;
		return isPalindromHelper(hp,right,0);
	}
	public boolean isPalindromHelper(Helper hp,Node right,int level) {
		if(right == null) {
			return true;
		}
		boolean res = isPalindromHelper(hp, right.next,level++);
		if(level < size/2) {
			if(res == false) {
				return false;
			}
			if(right.data != hp.left.data) {
				return false;
			}
			hp.left = hp.left.next;
		}
		return true;
	}
	
	
	//---------------------------class 28------------------------------------//
	public int mid() {
		Node f_point = this.head;
		Node s_point = this.head;
		while(f_point != null && f_point.next != null) {
			f_point = f_point.next.next;
			s_point = s_point.next;
		}
		return s_point.data;
	}
	
	public int kFromLast(int k) {
		Node fast = this.head;
		Node slow = this.head;
		for(int i=0;i<k;i++) {
			fast = fast.next;
		}
		while(fast != null) {
			fast = fast.next;
			slow= slow.next;
		}
		return slow.data;
	}
	
	public void fold() {
		Helper hp = new Helper();
		hp.left = this.head;
		Node right = this.head;
		fold(hp,right,0);
	}
	private void fold(Helper hp,Node right,int floor) {
		if(right == null) {
			return;
		}
		fold(hp,right.next,floor+1);
		if(floor>size/2) {
			Node currentNext = hp.left.next;
			hp.left.next = right;
			right.next = currentNext;
			hp.left = currentNext;
		}
		if(floor == size/2) {
			this.tail = right;
			this.tail.next = null;
		}
		
	}
	//---------------------------fold using global--------------------------//
	private Node left;
	public void fold2() {
		left = this.head;
		Node right = this.head;
		fold2(right,0);
	}
	private void fold2(Node right,int floor) {
		if(right == null) {
			return;
		}
		fold2(right.next,floor+1);
		if(floor>size/2) {
			Node currentNext = left.next;
			left.next = right;
			right.next = currentNext;
			left = currentNext;
		}
		if(floor == size/2) {
			this.tail = right;
			this.tail.next = null;
		}
		
	}
	
	
	
	
	public void reverseDS() {
		Helper hp = new Helper();
		hp.left = this.head;
		Node right = this.head;
		reverseDS(hp,right,0);
	}
	private void reverseDS(Helper hp,Node right,int floor) {
		if(right == null) {
			return;
		}
		reverseDS(hp,right.next,floor+1);
		if(floor >= size/2) {
			int temp = hp.left.data;
			hp.left.data = right.data;
			right.data = temp;
			hp.left = hp.left.next;
		}
	}
	
	
	//---------------------------class 29------------------------------------//
	public static Linklist mergeTwoSortedLists(Linklist l1,Linklist l2){
		Linklist res = new Linklist();
		Node temp1 = l1.head;
		Node temp2 = l2.head;
		while(temp1 != null && temp2 != null) {
			int val1 = temp1.data;
			int val2 = temp2.data;
			if(val1<val2) {
				res.addLast(val1);
				temp1 = temp1.next;
			}else {
				res.addLast(val2);
				temp2 = temp2.next;
			}
		}
		while(temp1 != null) {
			int val1 = temp1.data;
			res.addLast(val1);
			temp1 = temp1.next;
		}
		while(temp2 != null) {
			int val2 = temp2.data;
			res.addLast(val2);
			temp2 = temp2.next;
		}
		return res;
	}
	
	public void removeDuplicates() {
		Linklist list = new Linklist();
		while(this.size != 0) {
			if(list.size == 0 || list.tail.data != this.head.data) {
				list.addLastNode(this.removeFirstNode());
			}else {
				this.removeFirstNode();
			}
		}
		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}
	
	public void oddEvenSeperation() {
		Linklist odd = new Linklist();
		Linklist even = new Linklist();
		while(this.size>0) {
			if(this.head.data % 2 == 0) {
				even.addLastNode(this.removeFirstNode());
			}else {
				odd.addLastNode(this.removeFirstNode());
			}
		}
		if(odd.size>0 && even.size>0) {
			this.head=odd.head;
			this.tail = even.tail;
			this.size = odd.size + even.size;
		}else if(odd.size>0 && even.size == 0) {
			this.head=odd.head;
			this.tail = odd.tail;
			this.size = odd.size ;
		}else {
			this.head=even.head;
			this.tail = even.tail;
			this.size = even.size;
		}
	}
	public static void makeCycle(Linklist list) {
		list.tail.next = list.head;
	}
	
	public static boolean isCycle(Linklist list) {
		Node slow = list.head;
		Node fast = list.head;
		while(slow != null && fast != null && fast.next != null) {
			slow= slow.next;
			fast=fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
		
	}
	
	public void reversePR() {
		reversePR(head);
		Node temp = tail;
		this.tail = this.head;
		this.head = temp;
		tail.next = null;
	}
	private void reversePR(Node node) {
		if(node.next == null) {
			return;
		}
		reversePR(node.next);
		node.next.next = node;
	}
	
	
	
	
	
	
}
