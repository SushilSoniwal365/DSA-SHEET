import TreeClasses.TreeNode;

public class P_176_Binary_Tree_Maximum_Path_Sum {

    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

    // ! T.C = O(n) & S.C = O(n).
    static int maxSum; // Variable to store the maximum path sum

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumRecursive(root);
        return maxSum;
    }

    private static int maxPathSumRecursive(TreeNode node) {
        // Base case: If the node is null, return 0 (no contribution to the path sum)
        if (node == null) {
            return 0;
        }

        // Recursively calculate the maximum path sum in the left and right subtrees
        int leftMax = Math.max(0, maxPathSumRecursive(node.left)); // Ignore negative contributions
        int rightMax = Math.max(0, maxPathSumRecursive(node.right)); // Ignore negative contributions

        // Calculate the maximum path sum that includes the current node
        int currentMax = node.val + leftMax + rightMax;

        // Update the global maxSum if the current path is greater
        maxSum = Math.max(maxSum, currentMax);

        // Return the maximum path sum that can be extended upwards (either left or
        // right)
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
