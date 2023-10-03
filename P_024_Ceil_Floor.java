public class P_024_Ceil_Floor {

    // ? T.C = O(log n) & S.C = O(1).
    public static int ceil(int[] arr, int target) {
        // Ceil:- Smallest element >= target.

        int n = arr.length;
        if (target > arr[n - 1]) {
            return -1; // If target is greater than the maximum element in the array
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Found exact match
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return arr[start];
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int floor(int[] arr, int target) {
        // Floor:- Largest element <= target.

        int n = arr.length;
        if (target < arr[0]) {
            return -1; // If target is smaller than the minimum element in the array
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Found exact match
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[end];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        System.out.println(ceil(arr, 12));
        System.out.println(floor(arr, 20));
    }
}
