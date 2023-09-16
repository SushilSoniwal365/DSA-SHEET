import TreeClasses.Node;

public class P_162_Sum_Tree {

    // https://practice.geeksforgeeks.org/problems/sum-tree/1

    // ? T.C = O(n) & S.C = O(n)
    static boolean ans;

    public static boolean isSumTree(Node root) {
        ans = true;
        check(root);
        return ans;
    }

    private static int check(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int left = check(root.left);
        int right = check(root.right);
        if (left + right != root.data) {
            ans = false;
        }
        return left + right + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(isSumTree(root));
    }

}
