import TreeClasses.Node;

public class P_139_Count_Nodes_In_Binary_Tree {

    // https://practice.geeksforgeeks.org/problems/count-number-of-nodes-in-a-binary-tree/1

    // ! T.C = O(n) & S.C = O(n).
    public static int countNodes(Node root) {
        if (root == null)
            return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return (left + right + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(countNodes(root));
    }
}
