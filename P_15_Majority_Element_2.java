import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P_15_Majority_Element_2 {

    // https://leetcode.com/problems/majority-element-ii/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static List<Integer> majorityElement1(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > n / 3 && !res.contains(nums[i])) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    // * T.C = O(n) & S.C = O(n).
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums) {
            if (map.get(num) > nums.length / 3 && !res.contains(num))
                res.add(num);
        }

        return res;
    }

    // ! T.C = O(n) & S.C = O(1).
    public static List<Integer> majorityElement3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        if (nums == null || n == 0) {
            return res;
        }

        int num1 = nums[0], num2 = nums[0];
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == num1)
                cnt1++;
            else if (nums[i] == num2)
                cnt2++;
            else if (cnt1 == 0) {
                num1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                num2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1)
                cnt1++;
            else if (nums[i] == num2)
                cnt2++;
        }

        if (cnt1 > n / 3) {
            res.add(num1);
        }
        if (cnt2 > n / 3) {
            res.add(num2);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 3, 3, 5, 5 };
        List<Integer> ans = majorityElement3(arr);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
