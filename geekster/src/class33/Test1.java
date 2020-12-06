package class33;

import java.util.*;

public class Test1 {
	private class Node{
		int data;
		ArrayList<Node> childreen = new ArrayList<>();
	}
	int size;
	Node root;
	Test1(int[] arr){
		Stack<Node> st = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == -1) {
				st.pop();
			}else {
			Node node = new Node();
			node.data = arr[i];
			if(st.size()>0) {
				st.peek().childreen.add(node);
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
		System.out.print(root.data + "-->");
		for(Node child:root.childreen) {
			System.out.print(child.data+",");
		}
		System.out.println();
		for(Node child:root.childreen) {
//			System.out.println(child.data);
			display(child);
		}
	}
	
	public int size() {
		return size(this.root);
	}
	private int size(Node node) {
		int count = 0;
		for(Node child:node.childreen) {
			int temp = size(child);
			count += temp;
		}
		count = count+1;
		return count;
	}
	
	public int max() {
		return max(this.root);
	}
	private int max(Node node) {
		int max = node.data;
		for(Node child:node.childreen) {
			int temp = max(child);
			max  = Math.max(max, temp);
		}
		return max;
	}
	
	public boolean find(int num) {
		return find(this.root,num);
	}
	private boolean find(Node node,int num) {
		if(node.data == num) {
			return true;
		}
		boolean children = false;
		for(Node child:node.childreen) {
			 children = children || find(child,num);
		}
		return children;
	}
	
	public int height() {
		return height(this.root);
	}
	private int height(Node node) {
		int max = 0;
		for(Node child:node.childreen) {
			int temp = height(child);
			max  = Math.max(max, temp);
		}
		max++;
		return max;
	}
	
	public ArrayList<Integer> nodeToRootPath(int num){
		return nodeToRootPath(this.root,num);
		
	}
	private ArrayList<Integer> nodeToRootPath(Node node,int num){
		if(node.data == num) {
			ArrayList<Integer> ar = new ArrayList<>();
			ar.add(node.data);
			return ar;
		} 
		for(Node child:node.childreen) {
			ArrayList<Integer> temp = nodeToRootPath(child,num);
			if(temp.size()>0) {
				temp.add(node.data);
				return temp;
			}
		}
		return new ArrayList<>();
	}
	
	public void removeLeave() {
		removeLeave(this.root);
	}
	private void removeLeave(Node node) {
		for(int i=0;i<node.childreen.size();i++) {
			Node temp = node.childreen.get(i);
			if(temp.childreen.size() == 0) {
				node.childreen.remove(temp);
			}else {
				removeLeave(temp);
			}
		}
		
	}
	
	public void postOrder() {
		postOrder(this.root);
	}
	private void postOrder(Node root) {
		for(Node child:root.childreen) {
			postOrder(child);
		}
		System.out.print( root.data+",");
	}
	
	public void levelOrder() {
		levelOrder(this.root);
	}
	
	private void levelOrder(Node node) {
		LinkedList<Node> l1 = new LinkedList<>();
		LinkedList<Node> l2 = new LinkedList<>();
		l1.add(node);
		int level = 0;
		while(l1.size()>0) {
			Node temp = l1.removeLast();
			System.out.print(temp.data+ " ");
			if(level%2!=0) {
				for(int i=temp.childreen.size()-1;i>=0;i--) {
					l2.addLast(temp.childreen.get(i));
				}
			}else {
				for(int i=0;i<temp.childreen.size();i++) {
					l2.addLast(temp.childreen.get(i));
				}
			}
			
			if(l1.size() == 0) {
				l1= l2;
				l2 = new LinkedList<>();
				System.out.println();
				level++;
			}
		}
	}
}
