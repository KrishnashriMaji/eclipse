package class31;

public class Test {
	int data[];
	int font;
	int rear;
	int size;
	
	Test(int cap){
		this.data = new int[cap];
		this.font = -1;
		this.rear = -1;
		this.size = -1;
	}
	public void enque(int val) throws Exception {
		if(this.size == data.length) {
			throw new Exception("queue is full");
		}
		this.rear ++;
		this.rear = this.rear % data.length;
		this.data[this.rear] = val;
		if(this.size == -1) {
			this.font ++;
		}
		this.size ++;
	}
	public int deque() throws Exception{
		if(this.size == -1) {
			throw new Exception("queue is empty");
		}
		int temp = this.data[this.font];
		this.font++;
		this.font = this.font % data.length;
		this.size--;
		return temp;
	}
	public int font() throws Exception{
		if(this.size == -1) {
			throw new Exception("queue is empty");
		}
		return this.data[this.font];
	}
	public int size() {
		return this.size+1;
	}
	public void display() {
		for (int i = 0; i < this.size; i++) {
			System.out.print(data[(font + i) % data.length] + ",");
		}
	}
}
