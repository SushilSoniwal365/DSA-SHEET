import TreeClasses.TreeNode;

public class P_179_Morris_Preorder_Traversal {

    // ! T.C = O(n) & S.C = O(1).
    public static void morrisPreOrderTraversal(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // If the left subtree is null, visit the current node and move to the right.
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                // Find the rightmost node in the left subtree.
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Make the current node the right child of its in-order predecessor.
                    predecessor.right = current;
                    // Visit the current node and move to its left child.
                    System.out.print(current.val + " ");
                    current = current.left;
                } else {
                    // Restore original tree structure by breaking link from predecessor to current.
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Pre-order traversal using Morris Traversal:");
        morrisPreOrderTraversal(root);
    }
}
