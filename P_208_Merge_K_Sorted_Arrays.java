import java.util.ArrayList;
import java.util.PriorityQueue;

public class P_208_Merge_K_Sorted_Arrays {

    // https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

    // ? T.C = O(K^2*Log(K)) & S.C = O(K^2).
    static class Node implements Comparable<Node> {
        int value;
        int i;
        int j;

        public Node(int value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        // Create an ArrayList to store the merged sorted array
        ArrayList<Integer> mergedArray = new ArrayList<>();

        // Create a min-heap (PriorityQueue) to efficiently merge the arrays
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        // Initialize the min-heap with the first element from each array
        for (int i = 0; i < k; i++) {
            // Node class to store the element and its coordinates (i, j)
            minHeap.add(new Node(arr[i][0], i, 0));
        }

        // Repeat until the min-heap is empty
        while (!minHeap.isEmpty()) {
            // Remove the smallest element from the heap
            Node min = minHeap.poll();

            // Add the smallest element to the mergedArray
            mergedArray.add(min.value);

            // Check if there is a next element in the same array
            if (min.j + 1 < k) {
                // Add the next element from the same array to the min-heap
                minHeap.add(new Node(arr[min.i][min.j + 1], min.i, min.j + 1));
            }
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(mergeKArrays(arr, 3));
    }
}
