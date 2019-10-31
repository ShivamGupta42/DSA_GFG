package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	Node root;
	static int leftNodes = 0;
	static int rightNodes = 0;
	Queue<Node> que = new LinkedList<Node>();

	public Tree(Node root) {
		this.root = root;
	}

	void InOrderTraversal(Node root1) {
		if (root1 == null)
			return;

		if (root1.left != null) {
			InOrderTraversal(root1.left);
		}

		System.out.println(root1.data + " ");

		if (root1.right != null) {
			InOrderTraversal(root1.right);
		}
	}

	void LevelOrderTraversal(Node root2) {
		if (root2 == null)
			return;
		que.add(root2);

		Node levelEnd = root2;

		while (!que.isEmpty()) {
			Node x = que.remove();
			if (x == levelEnd) {
				System.out.println(x.data);
			} else {
				System.out.print(x.data + " ");
			}

			if (x.left != null) {
				que.add(x.left);
				levelEnd = x.left;
			}
			if (x.right != null) {
				que.add(x.right);
				levelEnd = x.right;
			}

		} // end

	}

	static void printLevelOrder(Node root) {
		// Base Case
		if (root == null)
			return;

		// Create an empty queue for level order tarversal
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue Root and initialize height
		q.add(root);

		while (true) {

			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;

			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while (nodeCount > 0) {
				Node node = q.peek();
				System.out.print(node.data + " ");
				q.remove();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}

	static int LevelOfANode(Node root, int key) {

		// Base Case
		if (root == null)
			return -1;

		Queue<Node> que = new LinkedList<Node>();

		que.add(root);
		int currentLevel = 0;
		int nodeAtCurLevel = 1;

		while (!que.isEmpty()) {
			currentLevel++;
			nodeAtCurLevel = que.size();

			for (int i = 0; i < nodeAtCurLevel; i++) {
				Node x = que.remove();

				if (x.data == key) {
					return currentLevel;
				}

				if (x.left != null) {
					que.add(x.left);
				}

				if (x.right != null) {
					que.add(x.right);
				}

			}

		}

		return 0;

	}

	public static void ZigZagTraversal(Node root) {
		if (root == null)
			return;

		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		boolean leftToRight = true;
		int nodeCount = currentLevel.size();
		currentLevel.push(root);

		while (!currentLevel.isEmpty()) {

			nodeCount = currentLevel.size();

			for (int i = 0; i < nodeCount; i++) {
				Node x = currentLevel.pop();
				System.out.print(x.data + " ");

				if (leftToRight) {

					if (x.left != null) {
						nextLevel.push(x.left);
					}

					if (x.right != null) {
						nextLevel.push(x.right);
					}

				} else {
					if (x.right != null) {
						nextLevel.push(x.right);
					}

					if (x.left != null) {
						nextLevel.push(x.left);
					}
				}

			}

			currentLevel = nextLevel;
			nextLevel = new Stack<Node>();
			leftToRight = !leftToRight;

		}

	}

	void printSpiral(Node node) {
		if (node == null)
			return;

		Stack<Node> curLvl = new Stack<Node>();
		Stack<Node> nextLvl = new Stack<Node>();
		curLvl.add(node);
		boolean leftToRight = false;
		int curLvlTotalNodes = 0;

		while (!curLvl.isEmpty()) {

			curLvlTotalNodes = curLvl.size();

			for (int i = 0; i < curLvlTotalNodes; i++) {
				Node x = curLvl.pop();
				System.out.print(x.data + " ");

				if (leftToRight) {
					if (x.left != null) {
						nextLvl.add(x.left);
					}
					if (x.right != null) {
						nextLvl.add(x.right);
					}

				} else {

					if (x.right != null) {
						nextLvl.add(x.right);
					}
					if (x.left != null) {
						nextLvl.add(x.left);
					}

				}
			}

			curLvl = nextLvl;
			nextLvl = new Stack<Node>();
			leftToRight = !leftToRight;

		}

	}

	void reverseOrderTraversal(Node root) {
		if (root == null)
			return;

		Queue<Node> curLevelNodes = new LinkedList<Node>();
		int currrentLevel = 0;
		int curLevelTotalNodes = 0;
		curLevelNodes.add(root);
		Node curNode = null;
		Node prevNode = null;

		while (!curLevelNodes.isEmpty()) {

			currrentLevel++;
			curLevelTotalNodes = curLevelNodes.size();

			for (int i = 0; i < curLevelTotalNodes; i++) {
			}

			Node x = curLevelNodes.remove();

			if (x.left != null) {
				curLevelNodes.add(x.left);
			}

			if (x.right != null) {
				curLevelNodes.add(x.right);
			}

		}

	}

	void connectRightNodes(Node root) {
		if (root == null)
			return;

		Queue<Node> curLevelNodes = new LinkedList<Node>();
		curLevelNodes.add(root);
		int curtotalNodes = 0;
		Node previous;

		while (!curLevelNodes.isEmpty()) {

			curtotalNodes = curLevelNodes.size();
			previous = null;

			for (int i = 0; i < curtotalNodes; i++) {
				Node x = curLevelNodes.remove();

				if (previous != null) {
					previous.nextRight = x;
				}
				previous = x;

				if (x.left != null) {
					curLevelNodes.add(x.left);
				}
				if (x.right != null) {
					curLevelNodes.add(x.right);
				}

			} // cur level node processing

		} // end

	}

	int heightOfTree1(Node root) {
		if (root == null)
			return 0;

		Queue<Node> que = new LinkedList<Node>();
		int currentHeight = -1;
		que.add(root);
		int currentNodes = 0;

		while (!que.isEmpty()) {
			currentHeight++;
			currentNodes = que.size();

			for (int i = 0; i < currentNodes; i++) {
				Node x = que.remove();
				if (x.left != null)
					que.add(x.left);
				if (x.right != null)
					que.add(x.right);
			}

		}

		return currentHeight;
	}

	int heightOfTree2(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(heightOfTree2(root.left), heightOfTree2(root.right));

	}

	int sizeOfATree(Node root) {

		if (root == null)
			return 0;

		Queue<Node> que = new LinkedList<Node>();
		int totalNodes = 0;
		que.add(root);
		int currentNodes = 0;

		while (!que.isEmpty()) {

			currentNodes = que.size();

			for (int i = 0; i < currentNodes; i++) {
				Node x = que.remove();
				totalNodes++;
				if (x.left != null)
					que.add(x.left);
				if (x.right != null)
					que.add(x.right);
			}

		}

		return totalNodes;
	}

	void printKdistance(Node node, int k) {
		if (node == null)
			return;

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		int curDistance = 0;
		int curWidth;

		while (!q.isEmpty()) {

			curWidth = q.size();

			for (int i = 0; i < curWidth; i++) {
				Node x = q.remove();

				if (curDistance == k) {
					System.out.print(x.data + " ");
				}

				if (x.left != null) {
					q.add(x.left);
				}

				if (x.right != null) {
					q.add(x.right);
				}

			}

			curDistance++;
		} // end of tree

	}

	void add(Node root1, Node node) {

		if (root1 == null || node == null || root1.data == node.data)
			return;

		if (root1.left == null || root1.left.data == node.data) {
			root1.left = node;
			return;
		}

		if (root1.right == null || root1.right.data == node.data) {
			root1.right = node;
			return;
		}

		if (leftNodes < rightNodes) {
			leftNodes++;
			add(root.left, node);
		} else {
			rightNodes++;
			add(root.right, node);
		}
	}

	public static boolean printAncestors(Node node, int x) {
		if (node == null)
			return false;
		if (node.data == x)
			return true;

		if (printAncestors(node.left, x) || printAncestors(node.right, x)) {
			System.out.print(node.data + " ");
			return true;
		}

		return false;
	}

	static boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		return (root1.data == root2.data) && (isIdentical(root1.left, root2.left))
				&& (isIdentical(root1.right, root2.right));

	}

	public static boolean isSubtree(Node T, Node S) {
		if (T == null || S == null)
			return false;

		Queue<Node> q = new LinkedList<Node>();
		q.add(T);
		int curWidth = 0;
		while (!q.isEmpty()) {
			curWidth = q.size();
			for (int i = 0; i < curWidth; i++) {
				Node x = q.remove();
				if (isIdentical(x, S)) {
					return true;
				}
				if (x.left != null) {
					q.add(x.left);
				}
				if (x.right != null) {
					q.add(x.right);
				}
			}
		}

		return false;
	}

	public static int isSumProperty(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		int sum = 0;
		if (node.left != null)
			sum += node.left.data;
		if (node.right != null)
			sum += node.right.data;

		if (node.data == sum && (isSumProperty(node.left) == 1) && (isSumProperty(node.right) == 1))
			return 1;

		return 0;

	}

	static boolean isBalanced(Node root) {
		if (root == null)
			return false;

		if (Math.abs(HeightOfTree(root.left) - HeightOfTree(root.nextRight)) <= 1)
			return true;
		return false;
	}

	static int HeightOfTree(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(HeightOfTree(root.left), HeightOfTree(root.left));
	}

}
