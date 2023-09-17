import TreeClasses.Node;

public class P_166_Maximum_Root_Leaf_Path_Sum {

    // https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1

    // ? T.C = O(n) & S.C = O(n).
    public static int maxPathSum(Node root) {
        return solve(root, 0);
    }

    private static int solve(Node node, int sum) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        sum += node.data;
        if (node.left == null && node.right == null) {
            return sum;
        }
        int left = solve(node.left, sum);
        int right = solve(node.right, sum);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(maxPathSum(root));
    }
}
