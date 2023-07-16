import java.util.HashMap;

public class P_48_Subarray_Sum_Equals_K {

    // https://leetcode.com/problems/subarray-sum-equals-k/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int subarraySum1(int[] arr, int k) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // * T.C = O(n) & S.C = O(n).
    public static int subarraySum2(int[] arr, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num : arr) {
            sum += num;
            int required = sum - k;
            if (preSum.containsKey(required)) {
                count += preSum.get(required);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 2 };
        System.out.println(subarraySum2(arr, 6));
    }
}
