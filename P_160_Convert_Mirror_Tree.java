import TreeClasses.Node;

public class P_160_Convert_Mirror_Tree {

    // https://practice.geeksforgeeks.org/problems/mirror-tree/1

    // ! T.C = O(n) & S.C = O(h).
    public static void mirror(Node node) {
        if (node == null) {
            return;
        }
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        Node curr = node.right;
        node.left = curr;
        node.right = temp;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        mirror(root);
    }
}
