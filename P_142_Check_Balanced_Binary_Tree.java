import TreeClasses.TreeNode;

public class P_142_Check_Balanced_Binary_Tree {

    // https://leetcode.com/problems/balanced-binary-tree/description/

    // ! T.C = O(n) & S.C = O(n).
    public static boolean isBalanced(TreeNode root) {
        // If the tree is empty, we can say it’s balanced...
        if (root == null)
            return true;

        // Height Function will return -1, when it’s an unbalanced tree...
        if (Height(root) == -1)
            return false;
        return true;
    }

    // Create a function to return the “height” of a current subtree.
    public static int Height(TreeNode root) {
        // Base case...
        if (root == null)
            return 0;

        // Height of left subtree...
        int leftHeight = Height(root.left);

        // Height of height subtree...
        int rightHight = Height(root.right);

        // In case of left subtree or right subtree unbalanced, return -1...
        if (leftHeight == -1 || rightHight == -1)
            return -1;

        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHight) > 1)
            return -1;

        // Otherwise, return the height of this subtree.
        return Math.max(leftHeight, rightHight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(isBalanced(root));
    }

}
