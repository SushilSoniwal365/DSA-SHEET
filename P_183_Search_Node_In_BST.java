import TreeClasses.TreeNode;

public class P_183_Search_Node_In_BST {

    // https://leetcode.com/problems/search-in-a-binary-search-tree/

    // ? T.C = O(h) & S.C = O(h).
    public static TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        if (root.val > target) {
            return searchBST(root.left, target);
        } else {
            return searchBST(root.right, target);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(13);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(17);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(22);

        System.out.println(searchBST(root, 20));
    }
}
