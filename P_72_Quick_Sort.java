import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/quick-sort/

public class P_72_Quick_Sort {

    // Todo:- Method to implement quick sort.
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot_idx = partition(arr, left, right);
            quickSort(arr, left, pivot_idx - 1);
            quickSort(arr, pivot_idx + 1, right);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;

        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i, low);
        return i;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 6, 10, 4, 3 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
