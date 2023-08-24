import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import TreeClasses.Node;

public class P_149_Vertical_Order_Traversal {

    // https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

    // ! T.C = O(n) & S.C = O(n).
    static class Pair {
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static ArrayList<Integer> verticalOrder(Node root) {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            if (map.containsKey(current.hd)) {
                map.get(current.hd).add(current.node.val);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(current.node.val);
                map.put(current.hd, temp);
            }

            if (current.node.left != null) {
                queue.add(new Pair(current.hd - 1, current.node.left));
            }
            if (current.node.right != null) {
                queue.add(new Pair(current.hd + 1, current.node.right));
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

        System.out.println(verticalOrder(root));
    }
}
