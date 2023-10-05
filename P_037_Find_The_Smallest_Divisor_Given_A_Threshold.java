public class P_037_Find_The_Smallest_Divisor_Given_A_Threshold {
    
    // https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

    // * T.C =  O(N * log(1e6)) & S.C = O(1)
    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1, end = (int) 1e6, ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += Math.ceil(num * 1.0 / mid);
            }
            if (sum > threshold) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 44, 22, 33, 11, 1 };
        System.out.println(smallestDivisor(arr, 5));
    }

}
