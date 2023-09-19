import TreeClasses.TreeNode;

public class P_180_Flatten_Binary_Tree_To_Linked_List {

    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

    // ! T.C = O(n) & S.C = O(1).
    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        flatten(root);
        System.out.println(root.val);
    }
}
