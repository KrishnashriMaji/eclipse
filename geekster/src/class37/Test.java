package class37;

import java.util.Stack;

public class Test {
	
	class Node{
		Node left;
		Node right;
		int data;
	}
	Node root;
	int size;
	
	Test(int[] arr){
		Stack<Node> st = new Stack<>();
		for(int i =0;i<arr.length;i++) {
			if(arr[i] == -1) {
				st.pop();
			}else {
				Node node = new Node();
				node.data= arr[i];
				if(st.size() == 0) {
					this.root = node;
				}else {
					
					if(st.peek().left == null) {
						st.peek().left = node;
					}else {
						st.peek().right = node;
					}
				}
				this.size++;
				st.push(node);
			}
		}
	}
	
	public void display() {
		display(this.root);
	}
	private void display(Node node) {
		if(node == null) {
			return;
		}else {
		String str = "";
		str += (node.left != null) ? node.left.data+"->" : "$->";
		str += (node.right != null) ? node.data+"->"+node.right.data : node.data+"<-$";
		System.out.println(str);
		display(node.left);
		display(node.right);
		}
		
	}
	
	public int size() {
		return size(this.root);
	}
	private int size(Node node) {
		if(node == null) {
			return 0;
		}else {
		int count = 0;
		count++;
		count += size(node.left);
		count += size(node.right);
		return count;
		}
		
	}
	
	public int max() {
		return max(this.root);
	}
	private int max(Node node) {
		
		int com = node.data;
		if(node.left != null) {
			int temp = max(node.left);
			com = Math.max(com,temp);
		}
		
		if(node.right != null) {
			int temp = max(node.right);
			com = Math.max(com,temp);
		}
		return com;
	}
	
	public int min() {
		return min(this.root);
	}
	private int min(Node node) {
		
		int com = node.data;
		if(node.left != null) {
			int temp = min(node.left);
			com = Math.min(com,temp);
		}
		
		if(node.right != null) {
			int temp = min(node.right);
			com = Math.min(com,temp);
		}
		return com;
	}
	
	public int height() {
		return height(this.root);
	}
	private int height(Node node) {
		if(node == null) {
			return 0;
		}else {
		
		int left = height(node.left);
		int right = height(node.right);
		int max = Math.max(left, right);
		return max+1;
		}
		
	}
	
	public boolean find(int data) {
		return find(this.root,data);
	}
	private boolean find(Node node,int data) {
		if(node == null) {
			return false;
		}else {
			if(node.data == data) {
				return true;
			}
			boolean temp = false;
			temp = find(node.left,data);
			if(!temp) {
			 temp = find(node.right,data);
			}
			
		return temp;
		}
		
	}
	
	public void removeLeaf() {
		 removeLeaf(this.root);
	}
	private void removeLeaf(Node node) {
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			return;
		}
		if(isLeaf(node.left)) {
			node.left=null;
		}
		if(isLeaf(node.right)) {
			node.right=null;
		}
		removeLeaf(node.left);
		removeLeaf(node.right);
		
	}
	
	private boolean isLeaf(Node node) {
		if(node == null) {
			return false;
		}else if(node.left == null && node.right == null) {
			return true;
		}else {
			return false;
		}
	}
	

	public void singleChild() {
		singleChild(this.root);
	}
	private void singleChild(Node node) {
		if(node == null) {
			return;
		}
		if(node.left != null && node.right == null) {
			System.out.println(node.left.data);
			singleChild(node.left);
		}
		else if((node.left) == null && (node.right) != null) {
			System.out.println(node.right.data);
			singleChild(node.left);
		}else {
			singleChild(node.left);
			singleChild(node.right);
		}
		
		
//		removeLeaf(node.right);
		
	}
}
