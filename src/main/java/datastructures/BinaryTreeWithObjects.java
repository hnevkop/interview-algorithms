package datastructures;

/**
 * Searching depth of a binary tree using objects.
 */
public class BinaryTreeWithObjects {

  public static void main(String[] args) {
    BinaryTreeWithObjects binaryTree = new BinaryTreeWithObjects();

    // The tree is:
    //         1
    //        / \
    //       2   3
    //      / \
    //     4   5

    // nodes
    TreeNode node1 = binaryTree.new TreeNode(1);
    TreeNode node2 = binaryTree.new TreeNode(2);
    TreeNode node3 = binaryTree.new TreeNode(3);
    TreeNode node4 = binaryTree.new TreeNode(4);
    TreeNode node5 = binaryTree.new TreeNode(5);

    // Connect nodes to form the tree.
    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;

    System.out.println("The maximum depth of the binary tree is: " + binaryTree.maxDepth(node1));
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
