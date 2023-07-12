public class P_27_Find_Peak_Element {

    // https://leetcode.com/problems/find-peak-element/description/

    // ? T.C = O(n) & S.C = O(1).
    public static int findPeakElement1(int[] arr) {
        int n = arr.length;
        int max_idx = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[max_idx])
                max_idx = i;
        }

        return max_idx;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int findPeakElement2(int[] arr) {
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
        int[] arr = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement2(arr));
    }
}
