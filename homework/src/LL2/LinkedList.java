package LL2;

public class LinkedList {
	public static void main(String[] args) {
		LinkedListHelper ll = new LinkedListHelper();
		ll.addLast(5);
		ll.addLast(10);
		ll.addLast(5);
		System.out.println(ll.getSize());
	}

}
   class LinkedListHelper {

		class Node{
			int data;
			Node next;
		}
		Node head;
		int size;
		Node tail;
		
		
		public int getSize() {
			return size;
		}
		
		
		public int getOccurance(int key) {
			int counter = 0;
			for(int i=0;i<size;i++) {
				if(key == getAt(i)) {
					counter++;
				}
			}
			return counter;
		}
		
		public int GetIndex_recursive(int value,int counter) {
			if(counter == size) {
				return -1;
			}
			if(value == getAt(counter)) {
				return counter;
			}
			return GetIndex_recursive(value,counter+1);
			
		}
		
		
		public int GetIndex(int value) {
			Node temp = head;
			int counter = 0;
			while(counter<size) {
				if(temp.data == value) {
					return counter;
				}
				temp= temp.next;
				counter++;
			}
			return -1;
		}
		
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


}
