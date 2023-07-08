public class P_03_Check_Rotated_Sorted_Array {

    // https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

    // ? T.C = O(n) & S.C = O(1).
    public static boolean check(int[] nums) {
        int n = nums.length;
        int wrong_order = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1])
                wrong_order++;
        }

        if (nums[n - 1] > nums[0])
            wrong_order++;

        return (wrong_order <= 1);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 6, 1, 2, 3, 4 };
        System.out.println(check(arr));
    }
}
