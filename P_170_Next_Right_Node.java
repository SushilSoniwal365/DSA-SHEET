import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.Node;

public class P_170_Next_Right_Node {

    // https://practice.geeksforgeeks.org/problems/next-right-node/1

    // ! T.C = O(n) & S.C = O(n).
    public static Node nextRight(Node root, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Node curr = q.poll();
                if (i < level - 1 && curr.data == key) {
                    return q.peek();
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return new Node(-1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node ansNode = nextRight(root, 5);
        System.out.println(ansNode.data);
    }
}
