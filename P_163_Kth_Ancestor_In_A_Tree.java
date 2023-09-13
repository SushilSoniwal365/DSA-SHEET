import java.util.ArrayList;

import TreeClasses.Node;

public class P_163_Kth_Ancestor_In_A_Tree {

    // https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1

    // ! T.C = O(n) & S.C = O(h).
    public static int kthAncestor(Node root, int k, int node) {

        ArrayList<Integer> path = new ArrayList<>();
        int ans = solve(root, path, node);
        if (ans == 0 || path.size() <= k)
            return -1;
        else
            return path.get(k);
    }

    public static int solve(Node root, ArrayList<Integer> path, int node) {
        if (root == null)
            return 0;
        if (root.data == node || solve(root.left, path, node) == 1 || solve(root.right, path, node) == 1) {
            path.add(root.data);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(kthAncestor(root, 2, 5));
    }
}
