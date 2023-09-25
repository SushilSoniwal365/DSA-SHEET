import java.util.PriorityQueue;

public class P_200_Kth_Largest_Element_In_An_Array {

    // https://leetcode.com/problems/kth-largest-element-in-an-array

    // ? T.C = O(n*logk) & S.C = O(k).
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, 1, 5, 3 };
        System.out.println(findKthLargest(arr, 3));
    }
}
