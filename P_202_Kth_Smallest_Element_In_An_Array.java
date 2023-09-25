import java.util.Comparator;
import java.util.PriorityQueue;

public class P_202_Kth_Smallest_Element_In_An_Array {

    // https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

    // ? T.C = O(n*logk) & S.C = O(k).
    public static int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
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
        System.out.println(kthSmallest(arr, 3));
    }
}
