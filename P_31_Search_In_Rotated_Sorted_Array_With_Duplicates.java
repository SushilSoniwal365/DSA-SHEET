public class P_31_Search_In_Rotated_Sorted_Array_With_Duplicates {

    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii

    // ? T.C = O(n) & S.C = O(1).
    public static boolean search1(int[] nums, int target) {
        for (int num : nums) {
            if (num == target)
                return true;
        }
        return false;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static boolean search2(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }

            // If left half of the array is sorted
            else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // If right half of the array is sorted
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // If element is not found
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 1 };
        System.out.println(search2(nums, 0));
    }
}
