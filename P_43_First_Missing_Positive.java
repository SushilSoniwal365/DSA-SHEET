import java.util.HashSet;

public class P_43_First_Missing_Positive {

    // https://leetcode.com/problems/first-missing-positive/description/

    // ? T.C = O(n) & S.C = O(n).
    public static int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i))
                return i;
        }
        return n + 1;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        int idx = 0;
        while (idx < n) {
            int correct_idx = nums[idx] - 1;
            if (nums[idx] > 0 && nums[idx] <= n && nums[idx] != nums[correct_idx]) {
                int temp = nums[idx];
                nums[idx] = nums[correct_idx];
                nums[correct_idx] = temp;
            } else {
                idx++;
            }
        }

        // Check for missing positive number.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1 };
        System.out.println(firstMissingPositive2(arr));
    }

}
