import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_169_Kth_Largest_Sum_In_Binary_Tree {

    // https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/

    // ! T.C = O(n) & S.C = O(n).
    public static long kthLargestLevelSum(TreeNode root, int k) {

        // Create a PriorityQueue (Min Heap) to keep track of K largest sums
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Create a Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform BFS
        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            // Add the current sum to the minHeap
            minHeap.offer(sum);

            // If the size of the minHeap exceeds K, remove the smallest sum
            if (minHeap.size() > k)
                minHeap.poll();
        }

        if (minHeap.size() > k) {
            return -1;
        }

        // The top element in the minHeap will be the Kth largest sum
        return minHeap.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);

        int k = 2;

        long result = kthLargestLevelSum(root, k);

        System.out.println("Kth largest sum in the Binary Tree is: " + result);

    }
}
