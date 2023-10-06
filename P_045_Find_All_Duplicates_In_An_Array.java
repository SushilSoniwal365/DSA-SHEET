import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P_045_Find_All_Duplicates_In_An_Array {

    // https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

    // ? T.C = O(n^2) & S.C = O(1) {TLE}.
    public static List<Integer> findDuplicates1(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    ans.add(arr[i]);
                }
            }
        }
        return ans;
    }

    // * T.C = O(n*logn) & S.C = O(1).
    public static List<Integer> findDuplicates2(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        while (i < n - 1) {
            if (arr[i] == arr[i + 1]) {
                ans.add(arr[i]);
                i += 2;
            } else {
                i++;
            }
        }

        return ans;
    }

    // ! T.C = O(n) & S.C = O(n)
    public static List<Integer> findDuplicates3(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i : arr) {
            if (set.contains(i)) {
                ans.add(i);
            } else {
                set.add(i);
            }
        }

        return ans;
    }

    // * T.C = O(n) & S.C = O(1).
    public static List<Integer> findDuplicates4(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length, i = 0;

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

        for (int idx = 0; idx < n; idx++) {
            if (arr[idx] != idx + 1) {
                ans.add(arr[idx]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates4(arr));
    }
}
