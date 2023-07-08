import java.util.Arrays;

public class P_11_Product_Of_Array_Except_Self {

    // https://leetcode.com/problems/product-of-array-except-self/description/

    // ? T.C = O(n^2) & S.C = O(1) {TLE}.
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int pro = 1;
            for (int j = 0; j < n; j++) {
                if (i != j)
                    pro *= nums[j];
            }
            ans[i] = pro;
        }
        return ans;
    }

    // * T.C = O(n) & S.C = O(1) {Not Work For 0}.
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length, pro = 1;
        int[] ans = new int[n];
        for (int num : nums) {
            pro *= num;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = pro / nums[i];
        }
        return ans;
    }

    // * T.C = O(n) & S.C = O(n).
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;

        // Array To Store Prefix Product Of Array.
        int[] pre_pro = new int[n];
        pre_pro[0] = 1;
        for (int i = 1; i < n; i++) {
            pre_pro[i] = nums[i - 1] * pre_pro[i - 1];
        }

        // Array To Store Suffix Product Of Array.
        int[] suf_pro = new int[n];
        suf_pro[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf_pro[i] = nums[i + 1] * suf_pro[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = pre_pro[i] * suf_pro[i];
        }

        return nums;
    }

    // ! T.C = O(n) & S.C = O(1).
    public static int[] productExceptSelf4(int[] nums) {
        int n = nums.length;

        // Array To Store Prefix Product Of Array.
        int[] pre_pro = new int[n];
        pre_pro[0] = 1;
        for (int i = 1; i < n; i++) {
            pre_pro[i] = nums[i - 1] * pre_pro[i - 1];
        }

        int temp = 1;
        for (int i = n - 1; i >= 0; --i) {
            pre_pro[i] = temp * pre_pro[i];
            temp *= nums[i];
        }

        return pre_pro;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        int[] res = productExceptSelf4(nums);
        System.out.println(Arrays.toString(res));
    }
}
