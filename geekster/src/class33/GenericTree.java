package class33;

import java.util.*;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree(int[] arr) {
		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node node = new Node();
				this.size++;
				node.data = arr[i];

				if (st.size() > 0) {
					st.peek().children.add(node);
				} else {
					this.root = node;
				}
				st.push(node);
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		System.out.print(node.data + "->");

		for (Node child : node.children) {
			if (child == null) {
				continue;
			}
			System.out.print(child.data + ",");
		}
		System.out.println(".");

		for (Node child : node.children) {
			if (child == null) {
				continue;
			}
			display(child);
		}
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int size = 0;
		for (Node child : node.children) {
			int csize = size2(child);
			size += csize;
		}

		size++;
		return size;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int cmax = max(child);
			max = Math.max(cmax, max);
		}

		return max;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

//		for (Node child : node.children) {
//			boolean childres = find(child, data);
//			if (childres == true) {
//				return true;
//			}
//		}
//
//		return false;
		
		
		boolean children = false;  
		for(Node child : node.children) {
			children = children || find(child,data);
		}
		return children;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int ht = 0;
		for (Node child : node.children) {
			int cht = height(child);
			ht = Math.max(cht, ht);
		}

		ht++;
		return ht;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {

		if (node.data == data) {
			ArrayList<Integer> bres = new ArrayList<Integer>();
			bres.add(node.data);
			return bres;
		}

		for (Node child : node.children) {
			ArrayList<Integer> rres = nodeToRootPath(child, data);
			if (rres.size() > 0) {
				rres.add(node.data);
				return rres;
			}
		}

		return new ArrayList<>(); // we cant return here null,if use null then  -->  if (rres != null) {
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(child);
			} else {
				removeLeaves(child);
			}
		}
	}
	
	//-----------------------------------class 35---------------------------------------------------//
	
	public void preOrder() {
		preOrder(this.root);
	}
	private void preOrder(Node node) {
		System.out.print(node.data+" ");
		for(Node child:node.children) {
			preOrder(child);
		}
	}
	
	public void postOrder() {
		postOrder(this.root);
	}
	private void postOrder(Node node) {
		
		for(Node child:node.children) {
			postOrder(child);
		}
		System.out.print(node.data+" ");
	}
	
	public void levelOrder() {
		LinkedList<Node> ln = new LinkedList<>();
		ln.addLast(this.root);
		while(ln.size()>0) {
			Node temp = ln.removeFirst();
			System.out.print(temp.data+" ");
			for(Node child:temp.children) {
				ln.addLast(child);
			}
		}
		
	}
	
	public void levelOrderLineWise() {
		LinkedList<Node> ln1 = new LinkedList<>();
		LinkedList<Node> ln2 = new LinkedList<>();
		ln1.addLast(this.root);
		while(ln1.size()>0) {
			Node temp = ln1.removeFirst();
			System.out.print(temp.data+" ");
			for(Node child:temp.children) {
				ln2.add(child);
			}
			if(ln1.size() == 0) {
				System.out.println();
				LinkedList<Node> ln3 = ln1;
				ln1 = ln2;
				ln2 = ln3;
			}
		}
		
	}
	
	public void printLevelOrderZigZag() {
		Stack<Node> currStack = new Stack<Node>();
		Stack<Node> nextStack = new Stack<>();
		currStack.push(this.root);
		int level = 0;
		while(currStack.size()>0) {
			Node node = currStack.pop();
			
			System.out.print(node.data+" ");
			if(level%2==0) {
				for(int i=0;i<node.children.size();i++) {
					nextStack.push(node.children.get(i));
				}
			}else {
				for(int i=node.children.size()-1;i>=0;i--) {
					nextStack.push(node.children.get(i));
				}
			}
			
			if(currStack.size()==0) {
				currStack = nextStack;
				nextStack = new Stack<>();
				System.out.println();
				level++;
			}
		}
	}
	
	public void mirror1() {
		LinkedList<Node> l1 = new LinkedList<>();
		LinkedList<Node> l2 = new LinkedList<>();
		l1.add(this.root);
		while(l1.size()>0) {
			Node node = l1.removeLast();
			System.out.print(node.data+" ");
			for(int i=node.children.size()-1;i>=0;i--) {
				l2.addFirst(node.children.get(i));
			}
			if(l1.size()==0) {
				l1 = l2;
				l2 = new LinkedList<>();
				System.out.println();
			}
		}
	}
	
	public void mirror() {
		mirror(root);
	}
	
	private void mirror(Node root) {
		for(Node n : root.children) {
			mirror(n);
		}
		Collections.reverse(root.children);
	}
	public boolean symtric() {
		Node r = this.root;
		ArrayList<Node> ar1 = new ArrayList<>();
		ArrayList<Node> ar2 = new ArrayList<>();
		ar1.add(r);
		while(ar1.size()>0) {
			Node temp = ar1.remove(0);
			for(int i=0;i<temp.children.size();i++) {
				ar2.add(temp.children.get(i));
			}
			
			if(ar1.size() == 0) {
				ar1 = ar2;
				ar2 = new ArrayList<>();
			}
			
		}
		return false;
		
	}
	
	

	

	public int LCA(int a,int b) {
		//verify all conditions

		// get path root to a aPath
		ArrayList<Integer> aPath = nodeToRootPath(a);	
		Collections.reverse(aPath);
		// get path root to b bPath
		ArrayList<Integer> bPath = nodeToRootPath(b);
		Collections.reverse(bPath);
		// compare the paths
		int i = 0;
		while(i < aPath.size() && i < bPath.size() && aPath.get(i) == bPath.get(i)) {
			i++;
		}

		return aPath.get(i-1);
	}

	private void linearize(Node root) {
		// linearise all node
		for(Node child:root.children) {
			linearize(child);
		}

		for(int i = root.children.size()-1;i>0;i--) {
			Node lc = root.children.remove(i);
			Node sl = root.children.get(i-1);
			Node slTail = getTail(sl);
			slTail.children.add(lc);
		}

	}
	private Node getTail(Node node) {
		Node temp = node;
		while(temp.children.size() != 0) {
			temp = temp.children.get(0);
		}
		return temp;
	}

	public void linarize() {
		linearize(root);
	}


}
