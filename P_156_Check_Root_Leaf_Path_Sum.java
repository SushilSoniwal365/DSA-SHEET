import TreeClasses.Node;

public class P_156_Check_Root_Leaf_Path_Sum {

    // https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1

    // ! T.C = O(n) & S.C = O(h).
    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false; // If the root is null, there's no path, return false.
        }

        // Subtract the current node's value from the target sum.
        sum -= root.val;

        // If it's a leaf node and the remaining sum is 0, we found a valid path.
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }

        // Recursively check the left and right subtrees.
        boolean leftPath = hasPathSum(root.left, sum);
        boolean rightPath = hasPathSum(root.right, sum);

        // Return true if there's a valid path in either subtree.
        return leftPath || rightPath;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(0);
        root.left.left = new Node(5);
        root.left.right = new Node(1);

        System.out.println(hasPathSum(root, 30));
    }
}
