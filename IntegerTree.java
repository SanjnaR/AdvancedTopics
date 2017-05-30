
public class IntegerTree extends BinarySearchTree {

	public IntegerTree() {

	}

	public IntegerTree(int[] data) {
		setRoot(sortedArrayToIT(data));
	}

	private TreeNode sortedArrayToIT(int[] arr, int start, int end ) {

		if(start > end) return null;
		int mid = start + (end - start)/ 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.setLeft(sortedArrayToIT(arr, start, mid-1));
		node.setRight(sortedArrayToIT(arr, mid+1, end));
		return node;
	}

	
	private TreeNode sortedArrayToIT(int[] arr) {
		return sortedArrayToIT(arr, 0, arr.length-1);
	}




	public int countNodes() {
		return countNodesHelper(root);
	}

	private int countNodesHelper(TreeNode root) {
		if(root == null) 
			return 0;
		else {
			return 1 + countNodesHelper(root.getLeft()) + countNodesHelper(root.getRight());
		}
	}

	private int treeSum() {
		return treeSumHelper(root);
	}

	private int treeSumHelper(TreeNode root) {
		if(root == null) 
			return 0;
		else {
			return (Integer)root.getValue() + treeSumHelper(root.getLeft()) + treeSumHelper(root.getRight());
		}
	}

	public int max() {
		//if theres no root
		//TreeNode p = getRoot();
		if(getRoot() == null) {
			return 0;
		}

		else {
			TreeNode p = null;
			TreeNode q = getRoot();
			boolean maxFound = false;

			while(q != null) {
				p = q;
				q = p.getRight();
			}

			return (Integer)p.getValue();

		}
	}

	public int min() {
		//if theres no root
		//TreeNode p = getRoot();
		if(getRoot() == null) {
			return 0;
		}

		else {
			TreeNode p = null;
			TreeNode q = getRoot();
			boolean maxFound = false;

			while(q != null) {
				p = q;
				q = p.getLeft();
			}

			return (Integer)p.getValue();

		}

	}

	public double treeAverage() {
		return (double)treeSum() / countNodes();
	}

	private int height() {
		if(getRoot() == null) {
			return 0;
		}

		else {
			int count = 0;
			TreeNode p = null;
			TreeNode q = getRoot();

			while(q != null) {
				p = q;
				q = p.getLeft();
				count++;
			}
			//			System.out.print("P" + p);
			//			System.out.print("Q" + q);


			p = null;
			q = getRoot();
			int i = 0;

			while(i < count) {
				p = q;
				q = p.getRight();
				i++;
			}


			while(q != null) {
				p = q;
				q = p.getRight();
				count++;
			}

			return count + 1;

		}

	}


	public static void main(String[] args) {
		IntegerTree t = new IntegerTree();
		t.insert(2);
		t.insert(5);
		t.insert(3);
		t.insert(4);
		t.insert(11);
		t.insert(9);
		t.inOrder();
		System.out.println("COUNT: ");
		System.out.println(t.countNodes());
		System.out.println("SUM: ");
		System.out.println(t.treeSum());
		System.out.println("Max Value ");
		System.out.println(t.max());
		System.out.println("Min Value ");
		System.out.println(t.min());
		System.out.println("Average ");
		System.out.println(t.treeAverage());
		System.out.println("Height ");
		System.out.println(t.height());

		int[] n = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		IntegerTree two  = new IntegerTree(n);
		two.inOrder();

	}






}
