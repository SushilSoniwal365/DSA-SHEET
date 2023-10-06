import java.util.Arrays;

public class P_047_Find_Missing_Repeating_Number {

    // https://rb.gy/abroi

    // ? T.C = O(n) & S.C = O(1).
    public static int[] findTwoElement(int nums[], int n) {
        int[] ans = new int[2];
        int idx = 0;
        while (idx < n) {
            int correct_idx = nums[idx] - 1;
            if (nums[idx] > 0 && nums[idx] <= n && nums[idx] != nums[correct_idx]) {
                int temp = nums[idx];
                nums[idx] = nums[correct_idx];
                nums[correct_idx] = temp;
            } else {
                idx++;
            }
        }

        // Check for missing and repeated number number.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans[0] = nums[i];
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 4, 1, 6 };
        System.out.println(Arrays.toString(findTwoElement(arr, arr.length)));
    }

}
