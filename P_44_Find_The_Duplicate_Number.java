import java.util.Arrays;
import java.util.HashSet;

public class P_44_Find_The_Duplicate_Number {

    // https://leetcode.com/problems/find-the-duplicate-number/description/

    // ? T.C = O(n^2) & S.C = O(1) {TLE}.
    public static int findDuplicate1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j])
                    return arr[i];
            }
        }
        return -1;
    }

    // * T.C = O(n*logn) & S.C = O(1).
    public static int findDuplicate2(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return n;
    }

    // ! T.C = O(n) & S.C = O(n)
    public static int findDuplicate3(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int findDuplicate4(int[] arr) {
        int i = 0, n = arr.length;
        while (i < n) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1)
                return arr[j];
        }
        return -1;
    }

    // ? T.C = O(n) & S.C = O(1).
    public static int findDuplicate5(int[] arr) {
        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            fast = arr[fast];
            slow = arr[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate5(nums));
    }
}
