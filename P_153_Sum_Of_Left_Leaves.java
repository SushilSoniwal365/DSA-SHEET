import java.util.LinkedList;
import java.util.Queue;
import TreeClasses.TreeNode;

public class P_153_Sum_Of_Left_Leaves {

    // https://leetcode.com/problems/sum-of-left-leaves/

    // ? T.C = O(n) & S.C = O(n).
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                if (current.left.left == null && current.left.right == null) {
                    sum += current.left.val;
                } else {
                    queue.offer(current.left);
                }
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(root));
    }
}
