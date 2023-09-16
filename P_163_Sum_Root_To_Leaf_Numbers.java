import TreeClasses.TreeNode;

public class P_163_Sum_Root_To_Leaf_Numbers {

    // https://leetcode.com/problems/sum-root-to-leaf-numbers/

    // ? T.C = O(n) & S.C = O(n).
    public static int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }

    private static int solve(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = solve(root.left, sum);
        int right = solve(root.right, sum);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(sumNumbers(root));
    }

}
