import java.util.HashMap;

public class P_07_Pair_Sum {

    // https://bit.ly/3ZpSNvf

    // ? T.C = O(n^2) & S.C = O(1).
    public static int getPairsCount1(int[] nums, int n, int k) {
        int pairs = 0;
        for (int first_idx = 0; first_idx < n; first_idx++) {
            for (int sec_idx = first_idx + 1; sec_idx < n; sec_idx++) {
                if (nums[first_idx] + nums[sec_idx] == k) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    // * T.C = O(n) & S.C = O(n).
    public static int getPairsCount2(int[] nums, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int num : nums) {
            int req = k - num;
            if (map.containsKey(req)) {
                pairs += map.get(req);
            }
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1 };
        int n = nums.length;
        int k = 2;

        System.out.println(getPairsCount2(nums, n, k));
    }
}
