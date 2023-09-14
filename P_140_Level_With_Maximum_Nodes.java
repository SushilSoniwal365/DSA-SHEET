import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.Node;

public class P_140_Level_With_Maximum_Nodes {

    // https://practice.geeksforgeeks.org/problems/maximum-node-level/1

    // ? T.C = O(n) & S.C = O(n).
    public static int maxNodeLevel(Node root) {
        int maxNodes = 0;
        int maxLevel = 0;
        int currLevel = 0;
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodes = queue.size();
            if (nodes > maxNodes) {
                maxNodes = nodes;
                maxLevel = currLevel;
            }
            for (int i = 0; i < nodes; i++) {
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            currLevel += 1;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(maxNodeLevel(root));
    }
}
