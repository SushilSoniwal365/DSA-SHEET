import java.util.Arrays;

public class P_028_First_Last_Position_Of_Element_In_Sorted_Array {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

    // ? T.C = O(n) & S.C = O(1).
    public static int[] searchRange1(int[] nums, int target) {
        int n = nums.length;
        int[] res = { -1, -1 };

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                } else {
                    res[1] = i;
                }
            }
        }

        // Check if first and last position is same.
        if (res[0] != -1 && res[1] == -1) {
            res[1] = res[0];
        }

        return res;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int[] searchRange2(int[] nums, int target) {
        int[] res = { -1, -1 };
        res[0] = search(nums, target, true);
        if (res[0] != -1) {
            res[1] = search(nums, target, false);
        }
        return res;
    }

    // Method For Binary Search.
    private static int search(int[] nums, int target, boolean isFirst) {
        int s = 0, e = nums.length - 1;
        int ans = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] < target) {
                s = m + 1;
            } else if (nums[m] > target) {
                e = m - 1;
            } else {
                if (isFirst) {
                    ans = m;
                    e = m - 1;
                } else {
                    ans = m;
                    s = m + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 8, 10 };
        System.out.println(Arrays.toString(searchRange2(arr, 8)));
    }
}
