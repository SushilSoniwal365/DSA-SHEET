public class P_204_Merge_Two_Binary_Max_Heaps {

    // https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1

    // ? T.C = O(n.logn) & S.C = O(n+m).
    public static int[] mergeHeaps(int[] heap1, int[] heap2) {
        int size1 = heap1.length;
        int size2 = heap2.length;

        int[] mergedHeap = new int[size1 + size2];

        // Copy elements from heap1 to the mergedHeap
        System.arraycopy(heap1, 0, mergedHeap, 0, size1);

        // Copy elements from heap2 to the mergedHeap, starting at position size1
        System.arraycopy(heap2, 0, mergedHeap, size1, size2);

        // Build a max heap from the mergedHeap
        buildMaxHeap(mergedHeap);

        return mergedHeap;
    }

    private static void buildMaxHeap(int[] heap) {
        int n = heap.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(heap, n, i);
        }
    }

    private static void maxHeapify(int[] heap, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap[largest] < heap[left]) {
            largest = left;
        }
        if (right < n && heap[largest] < heap[right]) {
            largest = right;
        }

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(heap, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] heap1 = { 3, 1, 5 };
        int[] heap2 = { 4, 2, 6 };

        int[] mergedHeap = mergeHeaps(heap1, heap2);

        // Print the merged heap
        for (int num : mergedHeap) {
            System.out.print(num + " ");
        }
    }
}