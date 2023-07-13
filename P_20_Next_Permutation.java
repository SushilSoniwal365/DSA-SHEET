import java.util.Arrays;

public class P_20_Next_Permutation {

    // https://leetcode.com/problems/next-permutation/

    // ? T.C = O(n) & S.C = O(1).
    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1, n - 1);
    }

    // * Method To Swap Two Numbers.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // * Method To Reverse The Array.
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
