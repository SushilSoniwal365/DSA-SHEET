import java.util.*;

public class P_14_Majority_Element {

    // https://leetcode.com/problems/majority-element/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int majorityElement1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    // * T.C = O(nlogn) & S.C = O(1).
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // ! T.C = O(n) & S.C = O(n).
    public static int majorityElement3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int majorityCount = nums.length / 2;
        for (int key : map.keySet()) {
            if (map.get(key) > majorityCount)
                return key;
        }
        return -1;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int majorityElement4(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == res) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                res = num;
                count = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement4(nums));
    }
}
