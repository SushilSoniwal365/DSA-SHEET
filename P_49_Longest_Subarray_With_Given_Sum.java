import java.util.HashMap;

public class P_49_Longest_Subarray_With_Given_Sum {

    // https://bit.ly/3dyZdp3

    // ? T.C = O(n^2) & S.C = O(1) {TLE}.
    public static int lenOfLongSubarr1(int[] arr, int n, int k) {
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0, currentLength = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    currentLength = j - i + 1;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    // * T.C = O(n) & S.C = O(n).
    public static int lenOfLongSubarr2(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        System.out.println(lenOfLongSubarr2(arr, arr.length, 15));
    }
}
