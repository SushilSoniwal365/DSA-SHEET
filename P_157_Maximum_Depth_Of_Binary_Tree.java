import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_157_Maximum_Depth_Of_Binary_Tree {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/

    // Todo:- Using BFS => T.C = O(n) & S.C = O(n).
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();
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
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth2(root));

    }
}
