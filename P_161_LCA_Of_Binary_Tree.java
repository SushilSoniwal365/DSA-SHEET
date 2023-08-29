import TreeClasses.TreeNode;

public class P_161_LCA_Of_Binary_Tree {

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

    // ! T.C = O(n) & S.C = O(h).
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null or equal to either p or q, it's the LCA
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for p and q in the left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both left and right subtrees return non-null values, root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one subtree returns a non-null value, pass it up
        return leftLCA != null ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode LCA = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(LCA.val);
    }
}
