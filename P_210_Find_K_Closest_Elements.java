import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P_210_Find_K_Closest_Elements {

    // https://leetcode.com/problems/find-k-closest-elements/description/

    // ? T.C = O(nlogk) & S.C = O(k).
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0)
            return new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (k-- > 0) {
                pq.offer(arr[i]);
            } else if (Math.abs(pq.peek() - x) > Math.abs(arr[i] - x)) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(findClosestElements(arr, 3, 3));
    }
}
