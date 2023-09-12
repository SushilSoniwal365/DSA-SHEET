import TreeClasses.Node;

public class P_157_Maximum_Root_Leaf_Sum {

    // https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1

    // ! T.C = O(n) & S.C = O(h).
    public static int maxPathSum(Node root) {
        return sumNumbersHelper(root, 0);
    }

    private static int sumNumbersHelper(Node node, int currentSum) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        currentSum = currentSum + node.data; // Update the current sum.

        // Check if it's a leaf node (both left and right are null).
        if (node.left == null && node.right == null) {
            return currentSum; // Return the current sum for leaf nodes.
        }

        // Recursively calculate the sum for left and right subtrees.
        int leftSum = sumNumbersHelper(node.left, currentSum);
        int rightSum = sumNumbersHelper(node.right, currentSum);

        // Return the maximum sum of left and right subtrees.
        return Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.right = new Node(-20);
        root.right.left = new Node(-30);

        System.out.println(maxPathSum(root));
    }
}
