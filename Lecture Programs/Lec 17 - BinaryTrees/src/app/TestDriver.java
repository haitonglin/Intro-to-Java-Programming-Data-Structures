package app;

public class TestDriver {
	public static void main(String[] args) {
		// The following inserts are all in order, creating a completely unbalanced tree
		BinaryTreeNode<Double> tree = BinaryTreeNode.put(null, 1.0, "one");
		BinaryTreeNode.put(tree, 2.0, "two");
		BinaryTreeNode.put(tree, 3.0, "three");
		BinaryTreeNode.put(tree, 4.0, "four");
		BinaryTreeNode.put(tree, 5.0, "five");

		// The following insert is out of order
		BinaryTreeNode.put(tree, 0.5, "half");

		// Look up 4.0 in the tree
		System.out.println("get 4.0 = " + BinaryTreeNode.get(tree, 4.0));

		// Do an inorder walk and print the keys (will be in alphabetical order)
		tree.printInorder();

		// Print the whole tree out
		tree.printTree(0);
	}
}