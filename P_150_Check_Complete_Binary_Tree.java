import java.util.LinkedList;
import java.util.Queue;
import TreeClasses.TreeNode;

public class P_150_Check_Complete_Binary_Tree {

    // https://leetcode.com/problems/check-completeness-of-a-binary-tree/

    // ? T.C = O(n) & S.C = O(n).
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean seenNull = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    return false;
                }
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isCompleteTree(root));
    }

}
