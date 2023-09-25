import java.util.PriorityQueue;

public class P_205_Minimum_Cost_Of_Ropes {

    // https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

    // ? T.C = O(nlogn) & S.C = O(n).
    public static long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : arr) {
            pq.add(num);
        }

        long cost = 0;
        while (pq.size() > 1) {
            long sum = 0;
            long a = pq.poll();
            long b = pq.poll();
            sum = a + b;
            pq.add(sum);
            cost += sum;
        }
        return cost;
    }

    public static void main(String[] args) {
        long[] arr = { 4, 3, 2, 6, 1 };
        System.out.println(minCost(arr, arr.length));
    }
}
