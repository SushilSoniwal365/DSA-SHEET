import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_138_Binary_Tree_ZigZag_LevelOrder_Traversal {

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

    // Todo:- Using Deque => T.C = O(n) & S.C = O(n).
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (reverse) {
                    TreeNode curr = queue.pollLast();
                    currentLevel.add(curr.val);

                    if (curr.right != null) {
                        queue.offerFirst(curr.right);
                    }
                    if (curr.left != null) {
                        queue.offerFirst(curr.left);
                    }
                } else {
                    TreeNode curr = queue.pollFirst();
                    currentLevel.add(curr.val);

                    if (curr.left != null) {
                        queue.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offerLast(curr.right);
                    }
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    // Todo:- Using Queue => T.C = O(n) & S.C = O(n).
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false; // To determine whether to reverse the order

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (reverse) {
                    levelValues.add(0, node.val); // Add at the beginning for reverse order
                } else {
                    levelValues.add(node.val);
                }

                // Add the children to the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(levelValues);
            reverse = !reverse; // Toggle the reverse flag for the next level
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder2(root);

        // Print the result.
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

}