public class P_040_Ship_Capacity {

    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

    // * T.C = O(n*log(high)) & S.C = O(1).
    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE, sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        int low = maxWeight, high = sum, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] nums, int targetSum, int days) {
        int currentSum = 0, numGroups = 1;
        for (int num : nums) {
            if (currentSum + num > targetSum) {
                currentSum = num;
                numGroups++;
            } else {
                currentSum += num;
            }
            if (numGroups > days) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(shipWithinDays(arr, 5));
    }
}
