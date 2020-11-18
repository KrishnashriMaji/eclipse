package class33;

import java.util.*;

public class Test1 {
	class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	private int size;
	private Node root;
	
	Test1(int[] arr){
		Stack<Node> st = new Stack<>();
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i] == -1) {
				st.pop();
			}else {
				Node node = new Node();
				node.data = arr[i];
				this.size++;
				if(st.size()>0) {
					st.peek().children.add(node);
				}else {
					this.root = node;
				}
				st.push(node);
			}
		}
		
	}
	
	public void display() {
		display(this.root);
	}
	
	private void display(Node root) {
		System.out.print(root.data +"---->");
		for(Node n : root.children) {
			System.out.print(n.data+", ");
		}
		System.out.println(".");
		for(Node c:root.children) {
			display(c);
		}
	}
	
	public int size2() {
		return size2(this.root);
	}
	private int size2(Node root) {
		int size = 0;
		for (Node child : root.children) {
			int csize = size2(child);
			size += csize;
		}

		size++;
		return size;
	}
	
	public int max() {
		return max(this.root);
	}
	private int max(Node root) {
		int max = root.data;
		for (Node child : root.children) {
			int res = max(child);
			max = Math.max(max, res);
		}

		return max;
	}
	
	public boolean find(int data) {
		return find(this.root,data);
	}
	private boolean find(Node n,int data) {
		if(data == n.data) {
			return true;
		}
		for (Node child : n.children) {
			boolean res = find(child,data);
			if(res == true) {
				return true;
			}
		}

		return false;
	}
	
	public int height() {
		return height(this.root);
	}
	
	private int height(Node n) {
		int max =0;
		for(Node c:n.children) {
			int res = height(c);
			max = Math.max(max, res);	
		}
		max++;
		return max;
	}
	
	public ArrayList<Integer> nodeToRootPath(int data){
		return nodeToRootPath(this.root,data);
	}
	private ArrayList<Integer> nodeToRootPath(Node n,int data){
		if(data == n.data) {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(n.data);
			return arr;
		}
		
		for(Node c:n.children) {
			ArrayList<Integer> res = nodeToRootPath(c,data);
			if(res != null) {
				res.add(n.data);
				return res;
			}
			
		}
		return null;
	}
	
	public void removeLeave() {
		removeLeave(this.root);
	}
	private void removeLeave(Node n) {
		for(int i=n.children.size()-1;i>=0;i--) {
			Node current = n.children.get(i);
			if(current.children.size() ==0) {
				n.children.remove(i);
			}else {
				removeLeave(current);
			}
		}
	}
	
}