package bfs;

public class Node {
	int data;
	Node left;
	Node right;
	Node nextRight;

	public Node(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return data + "";
	}
	
	

	public Node getNextRight() {
		return nextRight;
	}

	public void setNextRight(Node nextRight) {
		this.nextRight = nextRight;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Node))
			return false;
		Node a = (Node) obj;
		if (this.data != a.data)
			return false;
		
		if(this.left!=a.left||this.right!=a.right) {
			return false;
		}

		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode()+left.hashCode()+right.hashCode()+data;
	}

}
