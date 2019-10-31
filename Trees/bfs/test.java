package bfs;

public class test {

	public static void main(String[] args) {
		Node n = new Node(20);
		Tree t = new Tree(n);
		t.add(n, new Node(5));
		t.add(n, new Node(25));
		t.add(n, new Node(7));
		t.add(n, new Node(10));
		t.add(n, new Node(30));
		t.add(n, new Node(3));
		// t.InOrderTraversal(t.getRoot());
		// t.LevelOrderTraversal(n);
		t.ZigZagTraversal(n);
		System.out.println();
		t.printSpiral(n);
		//t.reverseOrderTraversal(n);

	}
}
