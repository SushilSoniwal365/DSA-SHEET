import TreeClasses.TreeNode;

public class P_160_Balanced_Binary_Tree {

    // https://leetcode.com/problems/balanced-binary-tree/

    // ? T.C = O(n) & S.C = O(n)
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (height(root) == -1) {
            return false;
        }
        return true;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isBalanced(root));
    }
}
