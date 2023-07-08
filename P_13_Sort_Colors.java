import java.util.Arrays;

public class P_13_Sort_Colors {

    // https://leetcode.com/problems/sort-colors/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static void sortColors1(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    // * T.C = O(nlogn) & S.C = O(1).
    public static void sortColors2(int[] nums) {
        Arrays.sort(nums);
    }

    // ! T.C = O(n) & S.C = O(1).
    public static void sortColors3(int[] nums) {
        int n = nums.length;
        int zeros = 0, ones = 0;
        for (int num : nums) {
            if (num == 0)
                zeros++;
            if (num == 1)
                ones++;
        }

        int idx = 0;
        while (zeros > 0) {
            nums[idx++] = 0;
            zeros--;
        }

        while (ones > 0) {
            nums[idx++] = 1;
            ones--;
        }

        while (idx < n) {
            nums[idx++] = 2;
        }
    }

    // * T.C = O(n) & S.C = O(1).
    public static void sortColors4(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1, temp;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                }

                case 1 -> mid++;

                case 2 -> {
                    temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;
                    high--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
