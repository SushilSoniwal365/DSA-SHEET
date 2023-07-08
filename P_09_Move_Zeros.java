import java.util.Arrays;

public class P_09_Move_Zeros {

    // https://leetcode.com/problems/move-zeroes/

    // ? T.C = O(n) & S.C = O(n).
    public static void moveZeroes1(int[] nums) {
        int n = nums.length, idx = 0;
        int[] temp = new int[n];
        for (int num : nums) {
            if (num != 0) {
                temp[idx++] = num;
            }
        }
        while (idx < n) {
            temp[idx++] = 0;
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    // * T.C = O(n) & S.C = O(1).
    public static void moveZeroes2(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        while (j < n) {
            if (nums[i] == 0 && nums[j] == 0) {
                j++;
            } else if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 3, 12, 0 };
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
