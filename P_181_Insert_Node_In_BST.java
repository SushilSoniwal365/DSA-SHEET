import TreeClasses.Node;

public class P_181_Insert_Node_In_BST {

    // https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1

    // ? T.C = O(h) & S.C = O(h).
    public static Node insert(Node root, int key) {
        if (root == null) {
            Node node = new Node(key);
            return node;
        }
        if (root.data == key) {
            return root;
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(13);
        root.right = new Node(20);
        root.left.left = new Node(12);
        root.left.right = new Node(17);
        root.right.left = new Node(18);
        root.right.right = new Node(22);

        root = insert(root, 14);
    }
}
