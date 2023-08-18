import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import Classes.TreeNode;

public class P_137_Binary_Tree_PreOrder_Traversal {

    // https://leetcode.com/problems/binary-tree-preorder-traversal/description/

    // ! T.C = O(n) & S.C = O(n).
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // Check if the tree is empty.
        if (root == null) {
            return new ArrayList<>();
        }

        // Create an empty stack and push the root node in it.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // Loop till stack is empty.
        while (!stack.isEmpty()) {

            // Pop the node from the stack and print it.
            TreeNode current = stack.pop();
            ans.add(current.val);

            // Push the right child of the popped node into the stack.
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push the left child of the popped node into the stack.
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(preorderTraversal(root));
    }
}
