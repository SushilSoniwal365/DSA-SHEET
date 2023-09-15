import java.util.LinkedList;
import java.util.Queue;
import TreeClasses.TreeNode;

public class P_151_Cousins_In_Binary_Tree {

    // https://leetcode.com/problems/cousins-in-binary-tree/

    // ? T.C = O(n) & S.C = O(n).
    public static boolean isCousins(TreeNode root, int x, int y) {
        // Check if the root is null, in which case x and y cannot be cousins.
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level.
            boolean foundX = false; // Indicates if node x is found at this level.
            boolean foundY = false; // Indicates if node y is found at this level.

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (curr.val == x) {
                    foundX = true;
                }

                if (curr.val == y) {
                    foundY = true;
                }

                // Check if x and y are children of the same parent.
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) ||
                            (curr.left.val == y && curr.right.val == x)) {
                        return false; // They have the same parent, so not cousins.
                    }
                }

                // Add the child nodes to the queue for the next level.
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            // If both x and y were found at this level, they are cousins.
            if (foundX && foundY) {
                return true;
            }

            // If only one of them was found at this level, they cannot be cousins.
            if (foundX || foundY) {
                return false;
            }
        }

        // If we reach this point, x and/or y were not found in the tree, so they cannot
        // be cousins.
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isCousins(root, 5, 6));
    }
}
