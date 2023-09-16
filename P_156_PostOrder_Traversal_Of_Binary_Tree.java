import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import TreeClasses.TreeNode;

public class P_156_PostOrder_Traversal_Of_Binary_Tree {

    // https://leetcode.com/problems/binary-tree-postorder-traversal/

    // Todo:- Using Stack => T.C = O(n) & S.C = O(n).
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
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

    // Todo:- Using Recursion => T.C = O(n) & S.C = O(n).
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private static void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(postorderTraversal2(root));
    }
}
