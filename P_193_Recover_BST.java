import TreeClasses.TreeNode;

public class P_193_Recover_BST {

    // https://leetcode.com/problems/recover-binary-search-tree/description/

    // ? T.C = O(n) & S.C = O(n).
    private static TreeNode first;
    private static TreeNode prev;
    private static TreeNode mid;
    private static TreeNode last;

    public static void recoverTree(TreeNode root) {
        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        if ((prev != null) && (root.val < prev.val)) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        recoverTree(root);
    }
}
