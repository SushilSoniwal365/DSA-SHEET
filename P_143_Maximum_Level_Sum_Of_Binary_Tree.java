import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_143_Maximum_Level_Sum_Of_Binary_Tree {

    // https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

    // ? T.C = O(n) & S.C = O(n).
    public static int maxLevelSum(TreeNode root) {
        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(maxLevelSum(root));
    }
}
