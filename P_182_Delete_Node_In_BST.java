import TreeClasses.TreeNode;

public class P_182_Delete_Node_In_BST {

    // https://leetcode.com/problems/delete-node-in-a-bst/

    // ? T.C = O(h) & S.C = O(h).
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = minValue(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private static int minValue(TreeNode node) {
        int min_val = node.val;
        while (node.left != null) {
            min_val = node.left.val;
            node = node.left;
        }
        return min_val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(13);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(17);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(22);

        System.out.println(deleteNode(root, 18).val);
    }
}
