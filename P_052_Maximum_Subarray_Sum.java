public class P_052_Maximum_Subarray_Sum {

    // https://leetcode.com/problems/maximum-subarray/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int maxSubArray1(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { -5, 4, 6, -3, 4, -1 };
        System.out.println(maxSubArray2(arr));
    }
}
