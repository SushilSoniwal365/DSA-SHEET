public class P_16_Best_Time_To_Buy_And_Sell_Stock_1 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int maxProfit1(int[] nums) {
        int n = nums.length;
        int profit = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] > profit) {
                    profit = nums[j] - nums[i];
                }
            }
        }
        return profit;
    }

    // * T.C = O(n) & S.C = O(n).
    public static int maxProfit2(int[] nums) {
        int n = nums.length;

        // Store The Maximum.
        int[] temp = new int[n];
        temp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            temp[i] = Math.max(temp[i + 1], nums[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int profit = temp[i] - nums[i];
            if (profit > res)
                res = profit;
        }
        return res;
    }

    // ! T.C = O(n) & S.C = O(1).
    public static int maxProfit3(int[] nums) {
        int n = nums.length;
        int min_so_far = nums[0];
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            min_so_far = Math.min(nums[i], min_so_far);
            int profit = nums[i] - min_so_far;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit3(nums));
    }

}
