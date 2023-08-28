import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_159_Symmetric_Tree {

    // https://leetcode.com/problems/symmetric-tree/description/

    // ! T.C = O(n) & S.C = O(h).
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode == null && rightNode == null) {
                continue; // Both nodes are null, continue to the next level
            }

            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false; // Nodes are not symmetric
            }

            // Enqueue child nodes in a way that ensures symmetry
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }

        return true; // If we reach this point, the tree is symmetric
    }

    public static void main(String[] args) {
        // Create a sample binary tree for testing.
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
