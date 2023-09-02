import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_168_Maximum_Level_Sum_Of_A_Binary_Tree {

    // https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/

    // ! T.C = O(n) & S.C = O(n).
    public static int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0; // If the tree is empty, return 0.
        }

        int maxLevel = 0; // To keep track of the level with the maximum sum.
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum with the minimum possible value.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Add the root node to the queue.
        int currentLevel = 1; // Initialize the current level to 1.

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            // Process all nodes in the current level.
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val; // Add the value of the current node to the level sum.

                // Add child nodes to the queue if they exist.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Update maxLevel and maxSum if the current level has a greater sum.
            if (levelSum > maxSum) {
                maxLevel = currentLevel;
                maxSum = levelSum;
            }

            // Move to the next level.
            currentLevel++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int maxLevel = maxLevelSum(root);
        System.out.println("Level with the maximum sum: " + maxLevel);
    }
}
