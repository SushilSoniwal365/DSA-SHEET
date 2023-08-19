import TreeClasses.Node;

public class P_140_Height_Of_Binary_Tree {

    // https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1

    // ! T.C = O(n) & S.C = O(n).
    public static int height(Node root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(height(root));
    }
}
