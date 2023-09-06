import TreeClasses.TreeNode;

public class P_172_Invert_Binary_Tree {

    // https://leetcode.com/problems/invert-binary-tree/description/

    // ! T.C = O(n) & S.C = O(n).
    public static TreeNode invertTree(TreeNode root) {
        // Base case: If the root is null, return null.
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees.
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right subtrees of the current root node.
        root.left = right;
        root.right = left;

        // Return the modified root.
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode newRoot = invertTree(root);
        System.out.println(newRoot.val);
    }
}
