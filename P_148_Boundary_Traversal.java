import java.util.ArrayList;

import TreeClasses.Node;

public class P_148_Boundary_Traversal {

    // https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

    // ! T.C = O(n) & S.C = O(n).
    public static ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        result.add(root.val);

        // Add left boundary.
        leftTraversal(root.left, result);

        // Add leaf boundary.
        leafTraversal(root, result);

        // Add right boundary.
        rightTraversal(root.right, result);

        return result;
    }

    // Function to add nodes to the left boundary.
    private static void leftTraversal(Node node, ArrayList<Integer> result) {
        if ((node == null) || (node.left == null && node.right == null)) {
            return;
        }
        result.add(node.val);

        if (node.left != null) {
            leftTraversal(node.left, result);
        } else {
            leftTraversal(node.right, result);
        }
    }

    // Function to add nodes to the leaf boundary.
    private static void leafTraversal(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            result.add(node.val);
        }

        leafTraversal(node.left, result);
        leafTraversal(node.right, result);
    }

    // Function to add nodes to the right boundary.
    private static void rightTraversal(Node node, ArrayList<Integer> result) {
        if ((node == null) || (node.left == null && node.right == null)) {
            return;
        }

        if (node.right != null) {
            rightTraversal(node.right, result);
        } else {
            rightTraversal(node.left, result);
        }

        result.add(node.val);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        System.out.println(boundary(root));

    }
}
