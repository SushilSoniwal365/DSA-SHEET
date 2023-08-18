import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Classes.TreeNode;

public class P_138_Binary_Tree_PostOrder_Traversal {

    // https://leetcode.com/problems/binary-tree-postorder-traversal/description/

    // ! T.C = O(n) & S.C = O(n).
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.peek();
                    stack.pop();
                    ans.add(temp.val);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.peek();
                        stack.pop();
                        ans.add(temp.val);
                    }
                } else {
                    current = temp;
                }
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

        System.out.println(postorderTraversal(root));
    }
}
