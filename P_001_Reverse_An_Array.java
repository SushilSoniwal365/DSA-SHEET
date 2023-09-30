import java.util.Arrays;

public class P_001_Reverse_An_Array {

    // ? T.C = O(n) & S.C = O(n).
    public static void reverse1(int[] nums) {
        int n = nums.length, idx = 0;
        int[] temp = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            temp[idx++] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // * T.C = O(n) & S.C = O(1).
    public static void reverse2(int[] nums) {
        int n = nums.length;
        int start_idx = 0, end_idx = n - 1;
        while (start_idx < end_idx) {
            int temp = nums[start_idx];
            nums[start_idx] = nums[end_idx];
            nums[end_idx] = temp;
            start_idx++;
            end_idx--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        reverse2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
