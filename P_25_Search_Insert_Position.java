public class P_25_Search_Insert_Position {

    // https://leetcode.com/problems/search-insert-position
    
    // ? T.C = O(logn) & S.C = O(1).
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        System.out.println(searchInsert(nums, 7));
    }
}
