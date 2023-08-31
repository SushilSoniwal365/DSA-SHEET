import TreeClasses.TreeNode;

public class P_165_Construct_Tree_From_Inorder_And_Preorder {

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

    // ! T.C = O(n) & S.C = O(n).
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // Check for empty arrays
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // Call the recursive helper function
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        // Base case: if the inorder start is greater than end, return null
        if (inStart > inEnd) {
            return null;
        }

        // Create a new root node using the current element from preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find the index of the root element in the inorder traversal
        int rootIndexInInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndexInInorder = i;
                break;
            }
        }

        // Calculate the number of elements in the left subtree
        int leftSubtreeSize = rootIndexInInorder - inStart;

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, rootIndexInInorder - 1);
        root.right = buildTreeHelper(preorder, inorder, preStart + leftSubtreeSize + 1, rootIndexInInorder + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = buildTree(preorder, inorder);

        System.out.println(root.val);
    }
}
