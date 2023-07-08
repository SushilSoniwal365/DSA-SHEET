import java.util.Arrays;
import java.util.HashSet;

public class P_08_Contains_Duplicate {

    // https://leetcode.com/problems/contains-duplicate/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static boolean containsDuplicate1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // * T.C = O(n*logn) & S.C = O(1).
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // ! T.C = O(n) & S.C = O(n).
    public static boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate3(nums));
    }
}
