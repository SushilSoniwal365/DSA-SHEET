import java.util.Arrays;

public class P_17_Rearrange_Array_Elements_By_Sign {

    // https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

    // ? T.C = O(n) & S.C = O(n).
    public static int[] rearrangeArray1(int[] nums) {
        int n = nums.length, pos_idx = 0, neg_idx = 0;
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        for (int num : nums) {
            if (num > 0) {
                pos[pos_idx++] = num;
            } else {
                neg[neg_idx++] = num;
            }
        }

        int p = 0, i = 0, j = 0;
        for (int idx = 0; idx < n; idx++) {
            if (idx % 2 == 0) {
                nums[p++] = pos[i++];
            } else {
                nums[p++] = neg[j++];
            }
        }

        return nums;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int[] rearrangeArray2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int positive = 0, negative = 1;

        for (int num : nums) {
            if (num > 0) {
                res[positive] = num;
                positive += 2;
            } else {
                res[negative] = num;
                negative += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        int[] res = rearrangeArray2(nums);
        System.out.println(Arrays.toString(res));
    }

}
