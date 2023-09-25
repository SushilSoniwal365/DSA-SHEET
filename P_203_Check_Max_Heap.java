import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.Node;

public class P_203_Check_Max_Heap {

    // https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1

    // ? T.C = O(n) & S.C = O(n).
    public static boolean isHeap(Node root) {
        return isCompleteTree(root) && isMaxHeap(root);
    }

    // * Check if the tree is a valid max heap
    private static boolean isMaxHeap(Node root) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.right == null) {
            return root.data >= root.left.data;
        }
        boolean left = isMaxHeap(root.left);
        boolean right = isMaxHeap(root.right);
        return left && right && root.data >= root.left.data && root.data >= root.right.data;
    }

    // * Check if the tree is a complete binary tree.
    private static boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean seenNull = false;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    return false;
                }
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(isHeap(root));
    }
}
