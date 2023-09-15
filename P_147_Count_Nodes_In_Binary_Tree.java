import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_147_Count_Nodes_In_Binary_Tree {

    // https://leetcode.com/problems/count-complete-tree-nodes/

    // ? T.C = O(n) & S.C = O(n).
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            count++;
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(countNodes(root));
    }

}
