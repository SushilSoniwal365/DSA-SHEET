import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_137_Binary_Tree_LevelOrder_Traversal {

    // https://leetcode.com/problems/binary-tree-level-order-traversal/description/

    // ? T.C = O(n) & S.C = O(n).
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
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

        List<List<Integer>> sol = levelOrder(root);

        for (List<Integer> ans : sol) {
            System.out.println(ans);
        }

    }
}
