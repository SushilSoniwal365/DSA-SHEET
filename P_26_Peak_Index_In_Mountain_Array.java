public class P_26_Peak_Index_In_Mountain_Array {

    // https://leetcode.com/problems/peak-index-in-a-mountain-array

    // ? T.C = O(n) & S.C = O(1).
    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int max_idx = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[max_idx])
                max_idx = i;
        }

        return max_idx;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int s = 0, e = n - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr[m] > arr[m + 1]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 5, 11, 6, 2 };
        System.out.println(peakIndexInMountainArray2(arr));
    }
}
