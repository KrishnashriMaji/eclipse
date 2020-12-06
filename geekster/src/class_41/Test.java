package class_41;

import java.util.ArrayList;

public class Test {
	ArrayList<Integer> arr = new ArrayList<>();
	
	public void add(int data) {
		arr.add(data);
		upheapify(arr.size()-1);
	}
	public void upheapify(int ci) {
		if(ci == 0) {
			return;
		}
		int pi = (ci-1)/2;
		if(isHP(ci,pi)) {
			swap(ci,pi);
			upheapify(pi);
		}
	}
	public boolean isHP(int ci,int pi) {
		return arr.get(ci)>arr.get(pi);  // for max heap
		
//		return arr.get(ci)<arr.get(pi);  // for min heap
	}
	public void swap(int ci,int pi) {
		int child = arr.get(ci);
		int parent = arr.get(pi);
		arr.set(ci, parent);
		arr.set(pi, child);
	}
	
	public int remove() {
		int top = arr.get(0);
		swap(0,arr.size()-1);
		arr.remove(arr.size()-1);
		downheapify(0);
		return top;
	}
	public void downheapify(int pi) {
		int max_index = pi;
        int lci = 2*pi + 1;
        if(lci < arr.size() && isHP(lci,max_index)==true){
            max_index = lci;
        }
        int rci = 2*pi + 2;
        if(rci < arr.size() && isHP(rci,max_index)==true){
            max_index = rci;
        }
        if(max_index != pi){
            swap(max_index,pi);
            downheapify(max_index);
        }
	}
	
	public  void display() {
		for(int a:arr) {
			System.out.print(a+ " ");
		}
	}
	public int size () {
		return arr.size();
	}
	public int peek() {
		return arr.get(0);
	}
	public boolean isEmpty() {
		return arr.isEmpty();
	}
	
	public ArrayList<Integer> kthElement(int num){
		ArrayList<Integer> newArr = new ArrayList<>();
		for(int i=0;i<num;i++) {
			newArr.add(arr.get(i));
		}
		for(int j=num;j<arr.size();j++) {
			for(int k=0;k<newArr.size();k++) {
				int temp = arr.get(j);
				if(arr.get(j)>newArr.get(k)) {
					newArr.set(k, temp);
				}
			}
		}
		return newArr;
	}
	
}
