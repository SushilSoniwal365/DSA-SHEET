import TreeClasses.Node;

public class P_186_Floor_In_BST {

    // https://practice.geeksforgeeks.org/problems/floor-in-bst/1

    // ? T.C = O(n) & S.C = O(1).
    public static int floor(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            } else if (root.data > key) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(13);
        root.right = new Node(20);
        root.left.left = new Node(12);
        root.left.right = new Node(14);
        root.right.left = new Node(18);
        root.right.right = new Node(22);

        System.out.println(floor(root, 16));
    }
}
