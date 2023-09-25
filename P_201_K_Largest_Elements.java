import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class P_201_K_Largest_Elements {

    // https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1

    // ? T.C = O(n*logk) & S.C = O(k).
    public static ArrayList<Integer> kLargest(int nums[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, 1, 5, 3 };
        System.out.println(kLargest(arr, arr.length, 3));
    }
}
