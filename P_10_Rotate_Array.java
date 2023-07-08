import java.util.Arrays;

public class P_10_Rotate_Array {

    // https://leetcode.com/problems/rotate-array/description/

    // ? T.C = O(n) & S.C = O(n).
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }

    // * T.C = O(n) & S.C = O(k).
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];
        int idx = 0;
        for (int i = n - k; i < n; i++) {
            temp[idx++] = nums[i];
        }

        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int p = 0; p < k; p++) {
            nums[p] = temp[p];
        }
    }

    // * T.C = O(n) & S.C = O(1).
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k > n) {
            return;
        }

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] arr, int start_idx, int end_idx) {
        int temp;
        while (start_idx < end_idx) {
            temp = arr[start_idx];
            arr[start_idx] = arr[end_idx];
            arr[end_idx] = temp;
            start_idx++;
            end_idx--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { -1, -100, 3, 99 };
        rotate2(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
