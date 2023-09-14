import java.util.ArrayList;

import TreeClasses.Node;

public class P_164_Root_To_Leaf_Paths {

    // https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1

    // ! T.C = O(n) & S.C = O(h).
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return res;
        solve(root, list, res);
        return res;
    }

    public static void solve(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;
        list.add(root.data);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        solve(root.left, list, res);
        solve(root.right, list, res);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(Paths(root));
    }
}
