import TreeClasses.TreeNode;

public class P_155_Sum_Root_To_Leaf_Numbers {

    // https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

    // ! T.C = O(n) & S.C = O(h).
    public static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private static int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0; // Base case: return 0 for null nodes
        }

        currentSum = currentSum * 10 + node.val; // Update the current sum

        // Check if it's a leaf node (both left and right are null)
        if (node.left == null && node.right == null) {
            return currentSum; // Return the current sum for leaf nodes
        }

        // Recursively calculate the sum for left and right subtrees
        int leftSum = sumNumbersHelper(node.left, currentSum);
        int rightSum = sumNumbersHelper(node.right, currentSum);

        // Return the sum of left and right subtrees
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(sumNumbers(root));
    }
}
