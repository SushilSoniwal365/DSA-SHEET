import java.util.Arrays;
import java.util.HashMap;

public class P_06_Two_Sum {

    // https://leetcode.com/problems/two-sum/description/

    // * T.C = O(n^2) & S.C = O(1).
    public static int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] { i, j };
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
                return new int[] { map.get(required), i };
            } else {
                map.put(current, i);
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int[] res = twoSum2(arr, 18);
        System.out.println(Arrays.toString(res));
    }
}
