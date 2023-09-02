import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_167_Average_Of_Levels_In_Binary_Tree {

    // https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

    // ! T.C = O(n) & S.C = O(n).
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result; // If the tree is empty, return an empty list.
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Add the root node to the queue.

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get the number of nodes in the current level.
            double levelSum = 0.0;

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

            // Calculate the average of the current level and add it to the result list.
            double levelAverage = levelSum / levelSize;
            result.add(levelAverage);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> averages = averageOfLevels(root);
        for (Double avg : averages) {
            System.out.println(avg);
        }
    }
}
