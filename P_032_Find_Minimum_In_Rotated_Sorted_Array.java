public class P_032_Find_Minimum_In_Rotated_Sorted_Array {

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

    // ? T.C = O(n) & S.C = O(1).
    public static int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        return min;
    }

    // ? T.C = O(log n) & S.C = O(1).
    public static int findMin2(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (m < e && nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }

            else if (m > s && nums[m] < nums[m - 1]) {
                return nums[m];
            }

            else if (nums[m] >= nums[s]) {
                s = m + 1;
            }

            else {
                e = m - 1;
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        System.out.println(findMin2(arr));
    }

}
