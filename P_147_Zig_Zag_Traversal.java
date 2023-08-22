import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_147_Zig_Zag_Traversal {

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

    // ! T.C = O(n) & S.C = O(n).
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result; // Return an empty list if the tree is empty.
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Add the root node to the queue.
        boolean isLeftToRight = true; // To track the zigzag direction

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level.
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level.
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Remove the current node from the queue.

                if (isLeftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val);
                }

                // Add the child nodes to the queue for processing in the next level.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        // Create a sample binary tree for testing.
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Get the level order traversal of the binary tree.
        List<List<Integer>> result = zigzagLevelOrder(root);

        // Print the result.
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
