package class33;

public class Client {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
//		int[] arr = {10,20,-1,30,-1,40,-1,-1};
		GenericTree gt = new GenericTree(arr);
//		gt.display();
//		System.out.println(gt.find(1209));
//		System.out.println(gt.nodeToRootPath(70));
		gt.removeLeaves();
		gt.display();
//		gt.preOrder();
//		gt.postOrder();
//		gt.levelOrder();
//		gt.linarize();
//		gt.levelOrderLineWise();
//		gt.printLevelOrderZigZag();
//		gt.mirror();
//		gt.display();
	}

}
