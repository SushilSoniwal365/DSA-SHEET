import java.util.LinkedList;
import java.util.Queue;
import TreeClasses.TreeNode;

public class P_152_Convert_Mirror_Tree_ {

    // https://practice.geeksforgeeks.org/problems/mirror-tree/1

    // ? T.C = O(n) & S.C = O(n).
    public static void mirror(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap left and right children of the current node
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add left and right children to the queue if they exist
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        mirror(root);
    }
}
