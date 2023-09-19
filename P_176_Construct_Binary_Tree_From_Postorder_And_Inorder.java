import TreeClasses.TreeNode;

public class P_176_Construct_Binary_Tree_From_Postorder_And_Inorder {

    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

    // ! T.C = O(n) & S.C = O(n).
    static int postIndex;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1; // Initialize postIndex

        // Create a helper function to build the tree recursively
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        // Base case: if the inorder start index is greater than the end index.
        if (inStart > inEnd) {
            return null;
        }

        // Find the index of the root in inorder array (within this method)
        int rootVal = postorder[postIndex];
        int rootIndexInInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }

        // Create a new TreeNode using the current postorder element at postIndex
        TreeNode root = new TreeNode(rootVal);
        postIndex--; // Move to the next element in postorder

        // Recursively build the right subtree first (postorder: left -> right -> root)
        root.right = buildTreeHelper(inorder, postorder, rootIndexInInorder + 1, inEnd);

        // Recursively build the left subtree (postorder: left -> right -> root)
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndexInInorder - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        TreeNode root = buildTree(inorder, postorder);

        System.out.println(root.val);
    }
}
