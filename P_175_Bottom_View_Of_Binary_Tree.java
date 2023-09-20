import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import TreeClasses.Node;

public class P_175_Bottom_View_Of_Binary_Tree {

    // https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1 

    // ! T.C = O(n) & S.C = O(n).
    static class Pair {
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static ArrayList<Integer> bottomView(Node root) {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(currentPair.node.data);
            map.put(currentPair.hd, temp);

            if (currentPair.node.left != null) {
                queue.add(new Pair(currentPair.hd - 1, currentPair.node.left));
            }
            if (currentPair.node.right != null) {
                queue.add(new Pair(currentPair.hd + 1, currentPair.node.right));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);
        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        System.out.println(bottomView(root));
    }
}