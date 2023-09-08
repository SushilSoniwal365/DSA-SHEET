import TreeClasses.Node;

public class P_143_Check_Identical_Tree {

    // https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

    // ! T.C = O(n) & S.C = O(n).
    public static boolean isIdentical(Node r1, Node r2) {
        // Base case: If both trees are empty, they are the same.
        if (r1 == null && r2 == null) {
            return true;
        }

        // If one tree is empty while the other is not, they are different.
        if ((r1 == null && r2 != null) || (r1 != null && r2 == null)) {
            return false;
        }

        // Check if the values of the current nodes are equal.
        if (r1.data != r2.data) {
            return false;
        }

        // Recursively check the left and right subtrees.
        return (isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right));
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(isIdentical(root1, root2));
    }
}
