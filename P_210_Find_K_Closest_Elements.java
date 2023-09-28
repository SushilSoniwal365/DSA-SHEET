import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P_210_Find_K_Closest_Elements {

    static class Pair implements Comparable<Pair> {
        int data;
        int sum;

        Pair(int d, int s) {
            this.data = d;
            this.sum = s;
        }

        public int compareTo(Pair ob) {
            if (ob.sum == this.sum) {
                return this.data - ob.data;
            }
            return this.sum - ob.sum;
        }
    }

    // https://leetcode.com/problems/find-k-closest-elements/description/

    // ? T.C = O(nlogk) & S.C = O(n+k).
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        List<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
        }

        for (int i = 0; i < k; i++) {
            Pair curr = pq.poll();
            al.add(curr.data);
        }
        Collections.sort(al);
        return al;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(findClosestElements(arr, 4, 3));
    }
}
