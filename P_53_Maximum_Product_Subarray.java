public class P_53_Maximum_Product_Subarray {

    // https://leetcode.com/problems/maximum-product-subarray/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int maxProduct1(int[] nums) {
        int n = nums.length;
        int maxPro = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currPro = 1;
            for (int j = i; j < n; j++) {
                currPro *= nums[j];
                maxPro = Math.max(maxPro, currPro);
            }
        }
        return maxPro;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int maxProduct2(int[] nums) {
        int n = nums.length;
        int pre = 1, suff = 1;
        int maxPro = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;

            pre *= nums[i];
            suff *= nums[n - i - 1];
            maxPro = Math.max(maxPro, Math.max(pre, suff));
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, -4, 3 };
        System.out.println(maxProduct2(arr));
    }
}
