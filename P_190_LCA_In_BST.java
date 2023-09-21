import TreeClasses.TreeNode;

public class P_190_LCA_In_BST {

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    // ? T.C = O(h) & S.C = O(1).
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Start from the root of the BST
        TreeNode current = root;

        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                // Both p and q are on the left subtree
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                // Both p and q are on the right subtree
                current = current.right;
            } else {
                // We found the lowest common ancestor
                return current;
            }
        }

        // If no common ancestor is found, return null
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode anc = lowestCommonAncestor(root, root.left.right, root.right.right);
        System.out.println(anc.val);
    }
}
