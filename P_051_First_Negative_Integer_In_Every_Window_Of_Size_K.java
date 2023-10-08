import java.util.ArrayList;
import java.util.Arrays;

public class P_051_First_Negative_Integer_In_Every_Window_Of_Size_K {

    // https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

    // ? T.C = O(n*k) & S.C = O(n).
    public static long[] printFirstNegativeInteger(long[] arr, int n, int k) {
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            boolean isFirst = false;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    isFirst = true;
                    list.add(arr[j]);
                    break;
                }
            }
            if (!isFirst) {
                list.add((long) 0);
            }
        }
        long[] res = new long[list.size()];
        for (long i = 0; i < list.size(); i++) {
            res[(int) i] = list.get((int) i);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = { -8, 2, 3, -6, 1 };
        long[] res = printFirstNegativeInteger(arr, arr.length, 2);

        System.out.println(Arrays.toString(res));
    }
}
