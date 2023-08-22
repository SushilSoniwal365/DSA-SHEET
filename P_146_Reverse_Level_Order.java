import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_146_Reverse_Level_Order {

    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

    // ! T.C = O(n) & S.C = O(n).
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result; // Return an empty list if the tree is empty.
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Add the root node to the queue.

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level.
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level.
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Remove the current node from the queue.
                currentLevel.add(currentNode.val); // Add the current node's value to the level list.

                // Add the child nodes to the queue for processing in the next level.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(0, currentLevel); // Add the current level list to the result.
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
        List<List<Integer>> result = levelOrderBottom(root);

        // Print the result.
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
