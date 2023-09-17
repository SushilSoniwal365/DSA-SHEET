import TreeClasses.Node;

public class P_167_Longest_Path_Sum {

    // https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1

    // ? T.C = O(n) & S.C = O(n).
    static int maxLen;
    static int maxSum;

    public static int sumOfLongRootToLeafPath(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxLen = 0;
        solve(root, 0, 0);
        return maxSum;
    }

    private static void solve(Node root, int sum, int len) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (len >= maxLen) {
                maxLen = len;
                sum += root.data;
                maxSum = sum;
                return;
            }
        }
        solve(root.left, sum + root.data, len + 1);
        solve(root.right, sum + root.data, len + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(sumOfLongRootToLeafPath(root));
    }
}
