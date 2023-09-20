import TreeClasses.Node;

public class P_185_Ceil_In_BST {

    // https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

    // ? T.C = O(n) & S.C = O(h).
    public static int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            } else if (root.data < key) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(13);
        root.right = new Node(20);
        root.left.left = new Node(12);
        root.left.right = new Node(14);
        root.right.left = new Node(18);
        root.right.right = new Node(22);

        System.out.println(findCeil(root, 12));
    }
}
