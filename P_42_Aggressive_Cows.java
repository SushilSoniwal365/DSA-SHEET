import java.util.Arrays;

public class P_42_Aggressive_Cows {

    // https://bit.ly/3rBuE5Z

    // * T.C = O(NlogN) & S.C = O(1).
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls); // sort the stalls array in increasing order
        int ans = 0;
        int low = 0, high = stalls[n - 1] - stalls[0]; // range of possible answers
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(stalls, mid, k)) { // check if mid is a valid answer
                ans = mid;
                low = mid + 1; // try to find a larger answer
            } else {
                high = mid - 1; // try to find a smaller answer
            }
        }
        return ans;
    }

    private static boolean isValid(int[] stalls, int d, int c) {
        int cows = 1;
        int pos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - pos >= d) {
                cows++;
                pos = stalls[i];
            }
        }
        return cows >= c;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 8, 9 };
        System.out.println(solve(arr.length, 3, arr));
    }
}
