import TreeClasses.TreeNode;

public class P_165_Root_To_Leaf_Path_Sum {

    // https://leetcode.com/problems/path-sum/

    // ? T.C = O(n) & S.C = O(n).
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        boolean left = hasPathSum(root.left, sum);
        boolean right = hasPathSum(root.right, sum);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(hasPathSum(root, 18));
    }

}
