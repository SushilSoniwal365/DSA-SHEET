import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import TreeClasses.TreeNode;

public class P_144_Kth_Largest_Sum_In_Binary_Tree {

    // https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree
    
    // ? T.C = O(n) & S.C = O(n).
    public static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            minHeap.add(sum);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if (minHeap.size() < k) {
            return -1;
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(kthLargestLevelSum(root, 2));
    }
}
