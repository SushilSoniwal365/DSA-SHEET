import java.util.PriorityQueue;

public class P_207_Kth_Largest_Sum_Subarray {

    // https://practice.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1

    // ? T.C = O(n^2*logk) & S.C = O(k).
    public static int kthLargest(int n, int k, int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                pq.add(sum);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = { -4, 5, -1, 0, 3 };
        System.out.println(kthLargest(arr.length, 3, arr));
    }
}
