import java.util.Arrays;

public class P_12_Missing_Number {

    // https://leetcode.com/problems/missing-number/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean isPresent = false;
            for (int num : nums) {
                if (i == num) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                return i;
            }
        }
        return n;
    }

    // * T.C = O(nlogn) & S.C = O(1).
    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    // ! T.C = O(n) & S.C = O(1).
    public static int missingNumber3(int[] nums) {
        int n = nums.length;

        // Iterate through the array and swap each element with its correct index.
        int idx = 0;
        while (idx < n) {
            int correct_idx = nums[idx];
            if (nums[idx] != n && nums[idx] != nums[correct_idx]) {
                int temp = nums[idx];
                nums[idx] = nums[correct_idx];
                nums[correct_idx] = temp;
            } else {
                idx++;
            }
        }

        // Return the first element that is not equal to its index.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    // ! T.C = O(n) & S.C = O(1).
    public static int missingNumber4(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1 };
        System.out.println(missingNumber4(arr));
    }
}
