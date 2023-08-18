import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Classes.TreeNode;

public class P_136_Binary_Tree_InOrder_Traversal {

    // https://leetcode.com/problems/binary-tree-inorder-traversal/description/

    // ! T.C = O(n) & S.C = O(n).
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    curr = stack.pop();
                    ans.add(curr.val);
                    curr = curr.right;
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

        System.out.println(inorderTraversal(root));
    }
}
