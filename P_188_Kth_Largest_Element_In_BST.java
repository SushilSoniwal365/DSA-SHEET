import TreeClasses.Node;

public class P_188_Kth_Largest_Element_In_BST {

    // https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

    // ? T.C = O(n) & S.C O(1).
    static int count;
    static int ans;

    public static int kthLargest(Node root, int k) {
        count = 0;
        ans = -1;
        inorder(root, k);
        return ans;
    }

    private static void inorder(Node root, int k) {
        Node current = root;

        while (current != null) {
            if (current.right == null) {
                ++count;
                if (count == k) {
                    ans = current.data;
                    return;
                }
                current = current.left;
            } else {
                Node predecessor = current.right;
                while (predecessor.left != null && predecessor.left != current) {
                    predecessor = predecessor.left;
                }

                if (predecessor.left == null) {
                    predecessor.left = current;
                    current = current.right;
                } else {
                    predecessor.left = null;
                    ++count;
                    if (count == k) {
                        ans = current.data;
                        return;
                    }
                    current = current.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(13);
        root.right = new Node(20);
        root.left.left = new Node(12);
        root.left.right = new Node(14);
        root.right.left = new Node(18);
        root.right.right = new Node(22);

        System.out.println(kthLargest(root, 4));
    }
}
