import TreeClasses.Node;

public class P_144_Sum_Tree {

    // https://practice.geeksforgeeks.org/problems/sum-tree/1

    // ! T.C = O(n) & S.C = O(n).

    private static boolean ans = true;

    private static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int left = sum(root.left);
        int right = sum(root.right);

        if (left + right != root.val) {
            ans = false;
        }
        return left + right + root.val;
    }

    public static boolean isSumTree(Node root) {
        sum(root);
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(isSumTree(root));
    }
}
