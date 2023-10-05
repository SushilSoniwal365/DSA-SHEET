public class P_038_Book_Allocation {

    // https://bit.ly/3QMrMxP

    // * T.C = O(n*log(n)) & S.C = O(1).
    public static int findPages(int[] books, int n, int students) {
        int max_Pages = Integer.MIN_VALUE, pages_Sum = 0;
        for (int page : books) {
            pages_Sum += page;
            max_Pages = Math.max(max_Pages, page);
        }

        if (students > n) {
            return -1;
        }

        if (students == n) {
            return max_Pages;
        }

        int low = max_Pages, high = pages_Sum, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossibleToAllocate(books, mid, students)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossibleToAllocate(int[] books, int mid, int students) {
        int current_pages = 0, req_students = 1;
        for (int pages : books) {
            current_pages += pages;
            if (current_pages > mid) {
                req_students++;
                current_pages = pages;
            }
        }
        return (req_students <= students);
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 67, 90 };
        System.out.println(findPages(arr, arr.length, 2));
    }
}