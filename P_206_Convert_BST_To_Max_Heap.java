import java.util.ArrayList;

import TreeClasses.Node;

public class P_206_Convert_BST_To_Max_Heap {

    // https://practice.geeksforgeeks.org/problems/bst-to-max-heap/1

    // ? T.C = O(n) & S.C = O(n).
    static int idx;

    public static void convertToMaxHeapUtil(Node root) {
        idx = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        postOrder(root, ans);
    }

    private static void inorder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    private static void postOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        postOrder(root.left, ans);
        postOrder(root.right, ans);
        if (idx < ans.size()) {
            root.data = ans.get(idx++);
        }
    }

    public static void printMaxHeap(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printMaxHeap(root.left);
        printMaxHeap(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        System.out.println("Original BST:");
        printMaxHeap(root);

        convertToMaxHeapUtil(root);

        System.out.println("\nMax Heap:");
        printMaxHeap(root);
    }
}
