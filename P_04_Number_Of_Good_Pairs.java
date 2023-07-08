import java.util.HashMap;

public class P_04_Number_Of_Good_Pairs {

    // https://leetcode.com/problems/number-of-good-pairs/

    // * T.C = O(n^2) & S.C = O(1).
    public static int numIdenticalPairs1(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // * T.C = O(n) & S.C = O(n).
    public static int numIdenticalPairs2(int[] nums) {
        int n = nums.length;
        int pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                pairs += map.get(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 3 };
        int pairs = numIdenticalPairs2(arr);
        System.out.println(pairs);
    }
}
