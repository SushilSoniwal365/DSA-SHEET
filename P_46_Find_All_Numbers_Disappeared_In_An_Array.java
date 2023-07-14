import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P_46_Find_All_Numbers_Disappeared_In_An_Array {

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    // ? T.C = O(n^2) & S.C = O(1) {TLE}.
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            boolean isPresent = false;
            for (int num : nums) {
                if (num == i) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                res.add(i);
            }
        }
        return res;
    }

    // * T.C = O(n) & S.C = O(n)
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    // ! T.C = O(n) & S.C = O(1).
    public static List<Integer> findDisappearedNumbers3(int[] arr) {
        List<Integer> missing = new ArrayList<>();
        int i = 0, n = arr.length;
        while (i < n) {
            int correct_idx = arr[i] - 1;
            if (arr[i] != arr[correct_idx]) {
                int temp = arr[i];
                arr[i] = arr[correct_idx];
                arr[correct_idx] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1)
                missing.add(j + 1);
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers3(arr));
        ;
    }
}
