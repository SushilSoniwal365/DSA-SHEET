import TreeClasses.TreeNode;

public class P_141_Diameter_Of_Binary_Tree {

    // https://leetcode.com/problems/diameter-of-binary-tree/description/

    // ! T.C = O(n) & S.C = O(n).
    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return maxDiameter;
    }

    private static int calculateDiameter(TreeNode node) {
        if (node == null)
            return 0;

        int leftPath = calculateDiameter(node.left);
        int rightPath = calculateDiameter(node.right);

        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, leftPath + rightPath);

        // Return the maximum depth of this node's subtree
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}
