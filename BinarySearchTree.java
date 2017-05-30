
public class BinarySearchTree extends BinaryTree {

	@Override
	public void insert(Comparable item) {
		//if theres no root
		//TreeNode p = getRoot();
		TreeNode newNode = new TreeNode(item.toString());
		if(getRoot() == null) {
			setRoot(new TreeNode(item));
		}

		else {
			TreeNode p = null;
			TreeNode q = getRoot();

			while( q != null ) {
				p = q;
				if(item.compareTo((Comparable)p.getValue()) < 0) {	
					q = p.getLeft();
				}

				else {
					q = p.getRight();
				}
			}

			if(item.compareTo((Comparable)p.getValue()) < 0) {
				p.setLeft(new TreeNode(item));
			}

			else {
				p.setRight(new TreeNode(item));
			}
		}

	}

	@Override
	public TreeNode find(Comparable key) {
		TreeNode p = getRoot();
		while( p != null && key.compareTo(p) != 0) {
			if(key.compareTo(p.getValue()) > 0) {	
				p.getLeft();
			}

			else {
				p.getRight();
			}
		}
		return p;
	}

	public void inOrder() {
		inOrder(getRoot());
	}

	public void inOrder(TreeNode root) {
		if(root!=null) {
			inOrder(root.getLeft());

			System.out.println(root.getValue());
			inOrder(root.getRight());
		}
	}

	public static void main(String[] args) {
		BinarySearchTree one = new BinarySearchTree();
		one.insert("fig");
		one.insert("apple");
		one.insert("aardvark");
		one.insert("lemon");
		one.insert("grape");
		one.insert("blueberry");
		one.insert("pineapple");
		one.insert("grape");


		one.inOrder();


	}




}
