import java.util.Arrays;
import java.util.HashMap;

public class P_023_Two_Sum_Sorted {

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

    // ? T.C = O(n^2) & S.C = O(1).
    public static int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // * T.C = O(n) & S.C = O(n).
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int required = target - current;
            if (map.containsKey(required)) {
                return new int[] { map.get(required) + 1, i + 1 };
            } else {
                map.put(current, i);
            }
        }
        return new int[] { -1, -1 };
    }

    // ? T.C = O(n) & S.C = O(1).
    public static int[] twoSum3(int[] nums, int target) {
        int start_idx = 0, end_idx = nums.length - 1;
        while (start_idx < end_idx) {
            int sum = nums[start_idx] + nums[end_idx];
            if (sum == target) {
                return new int[] { start_idx + 1, end_idx + 1 };
            } else if (sum > target) {
                end_idx--;
            } else {
                start_idx++;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum3(arr, target)));
    }
}
