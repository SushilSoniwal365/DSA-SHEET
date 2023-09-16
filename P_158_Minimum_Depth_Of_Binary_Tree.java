import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_158_Minimum_Depth_Of_Binary_Tree {

    // https://leetcode.com/problems/minimum-depth-of-binary-tree/

    // Todo:- Using BFS => T.C = O(n) & S.C = O(n).
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // If we encounter a leaf node, return the current depth
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // Todo:- Using DFS => T.C = O(n) & S.C = O(n).
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If the node is a leaf node, return 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;

        // Calculate the minimum depth of left and right subtrees
        if (root.left != null) {
            leftDepth = minDepth(root.left);
        }
        if (root.right != null) {
            rightDepth = minDepth(root.right);
        }

        // Return the minimum depth among left and right subtrees
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(minDepth2(root));

    }
}
