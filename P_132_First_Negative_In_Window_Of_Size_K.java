import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class P_132_First_Negative_In_Window_Of_Size_K {

    // https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

    // ? T.C = O(n) & S.C = O(k).
    public static long[] printFirstNegativeInteger(long[] arr, int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                q.addLast(i);
            }
        }

        if (q.size() > 0) {
            ans.add((int) arr[q.getFirst()]);
        } else {
            ans.add(0);
        }

        for (int i = k; i < n; i++) {
            if (!q.isEmpty() && i - q.getFirst() >= k) {
                q.pollFirst();
            }

            if (arr[i] < 0) {
                q.addLast(i);
            }

            if (q.size() > 0) {
                ans.add((int) arr[q.getFirst()]);
            } else {
                ans.add(0);
            }
        }

        long[] res = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        long[] arr = { -8, 2, 3, -6, 10 };
        System.out.println(Arrays.toString(printFirstNegativeInteger(arr, arr.length, 2)));
    }
}
