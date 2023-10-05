public class P_039_Split_Array_Largest_Sum {

    // https://leetcode.com/problems/split-array-largest-sum

    // * T.C = O(n*log(n)) & S.C = O(1).
    public static int splitArray(int[] nums, int m) {
        int maxNum = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            if (num > maxNum) {
                maxNum = num;
            }
        }

        int low = maxNum, high = sum, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValidSplit(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isValidSplit(int[] nums, int targetSum, int numSplits) {
        int currentSum = 0, numGroups = 1;
        for (int num : nums) {
            if (currentSum + num > targetSum) {
                currentSum = num;
                numGroups++;
            } else {
                currentSum += num;
            }
            if (numGroups > numSplits) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        System.out.println(splitArray(nums, 2));
    }

}
