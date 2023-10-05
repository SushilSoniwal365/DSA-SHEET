public class P_033_Find_Minimum_In_Rotated_Sorted_Array_With_Duplicates {

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

    // ? T.C = O(n) & S.C = O(1).
    public static int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        return min;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int findMin2(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (nums[m] > nums[e]) {
                s = m + 1;
            } else if (nums[m] < nums[e]) {
                e = m;
            } else {
                e--;
            }
        }
        return nums[s];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 1, 1, 1 };
        System.out.println(findMin2(arr));
    }
}
