public class P_35_Max_Consecutive_Ones {

    // https://leetcode.com/problems/max-consecutive-ones

    // * T.C = O(n) & S.C = O(1).
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, c = 0;
        for (int num : nums) {
            if (num == 1) {
                c++;
            } else {
                max = Math.max(max, c);
                c = 0;
            }
        }
        max = Math.max(max, c);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
