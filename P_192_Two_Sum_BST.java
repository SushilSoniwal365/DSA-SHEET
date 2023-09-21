import java.util.Stack;

import TreeClasses.TreeNode;

class BSTIterator {
    private Stack<TreeNode> myStack = new Stack<>();
    private boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !myStack.isEmpty();
    }

    public int next() {
        TreeNode temp = myStack.pop();
        if (!reverse) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }
        return temp.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            myStack.push(node);
            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

public class P_192_Two_Sum_BST {

    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

    // ? T.C = O(n) & S.C = O(h)
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        BSTIterator leftIterator = new BSTIterator(root, false);
        BSTIterator rightIterator = new BSTIterator(root, true);

        int i = leftIterator.next();
        int j = rightIterator.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j > k) {
                j = rightIterator.next();
            } else {
                i = leftIterator.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println(findTarget(root, 11));
    }
}
