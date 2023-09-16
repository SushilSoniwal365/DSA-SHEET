import TreeClasses.TreeNode;

public class P_159_Diameter_Of_Binary_Tree {

    // https://leetcode.com/problems/diameter-of-binary-tree/description/

    // ? T.C = O(n) & S.C = O(n).
    static int maxDiameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateDiameter(root);
        return maxDiameter;
    }

    private static int calculateDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateDiameter(root.left);
        int right = calculateDiameter(root.right);

        maxDiameter = Math.max(maxDiameter, left + right);
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

        System.out.println(diameterOfBinaryTree(root));
    }

}
