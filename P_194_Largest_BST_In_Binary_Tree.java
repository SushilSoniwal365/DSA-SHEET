import TreeClasses.Node;

class NodeVal {
    public int minVal;
    public int maxVal;
    public int maxSize;

    public NodeVal(int minVal, int maxVal, int maxSize) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.maxSize = maxSize;
    }
}

public class P_194_Largest_BST_In_Binary_Tree {

    // https://practice.geeksforgeeks.org/problems/largest-bst/1

    // ? T.C = O(n) & S.C = O(h).
    public static int largestBst(Node root) {
        return largestBstHelper(root).maxSize;
    }

    private static NodeVal largestBstHelper(Node root) {
        if (root == null) {
            return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeVal left = largestBstHelper(root.left);
        NodeVal right = largestBstHelper(root.right);

        if (left.maxVal < root.data && right.minVal > root.data) {
            return new NodeVal(
                    Math.min(root.data, left.minVal),
                    Math.max(root.data, right.maxVal),
                    left.maxSize + right.maxSize + 1);
        } else {
            return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
        }
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.right = new Node(9);

        System.out.println(largestBst(root));
    }
}
