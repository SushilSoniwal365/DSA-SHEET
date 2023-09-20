import TreeClasses.TreeNode;

public class P_184_Check_For_BST {

    // https://leetcode.com/problems/validate-binary-search-tree/description/

    // ? T.C = O(n) & S.C = O(n).
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(13);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(17);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(22);

        System.out.println(isValidBST(root));
    }
}
