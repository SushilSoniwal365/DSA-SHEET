import java.util.LinkedList;
import java.util.Queue;
import TreeClasses.Node;

public class P_139_Find_Level_Of_A_Node {

    // https://practice.geeksforgeeks.org/problems/level-of-a-node-in-binary-tree/1

    // ? T.C = O(n) & S.C = O(n).
    public static int getLevel(Node root, int data) {
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.data == data) {
                    return level;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level += 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(getLevel(root, 5));
    }
}
