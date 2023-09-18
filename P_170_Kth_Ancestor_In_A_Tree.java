import java.util.ArrayList;
import TreeClasses.Node;

public class P_170_Kth_Ancestor_In_A_Tree {

    // https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1

    // ? T.C = O(n) & S.C = O(h).
    public static int kthAncestor(Node root, int k, int node) {
        ArrayList<Integer> ancestors = new ArrayList<>();
        int ans = solve(root, ancestors, node);
        if (ans == 0 || ancestors.size() <= k) {
            return -1;
        } else {
            return ancestors.get(k);
        }
    }

    private static int solve(Node root, ArrayList<Integer> ancestors, int node) {
        if (root == null) {
            return 0;
        }
        if (root.data == node) {
            ancestors.add(root.data);
            return 1;
        }
        int left = solve(root.left, ancestors, node);
        int right = solve(root.right, ancestors, node);
        if (left == 1 || right == 1) {
            ancestors.add(root.data);
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

        System.out.println(kthAncestor(root, 1, 4));
    }
}
