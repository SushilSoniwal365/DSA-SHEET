import TreeClasses.TreeNode;

public class P_187_Kth_Smallest_Element_In_BST {

    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

    // ? T.C = O(n) & S.C O(h).
    static int count;
    static int ans;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = Integer.MIN_VALUE;
        inorder(root, k);
        return ans;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(13);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(22);

        System.out.println(kthSmallest(root, 4));
    }
}
