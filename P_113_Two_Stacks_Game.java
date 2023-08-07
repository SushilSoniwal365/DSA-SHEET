import java.util.Arrays;

public class P_113_Two_Stacks_Game {

    // https://www.hackerrank.com/challenges/game-of-two-stacks/problem

    public static int stacksGame(int[] arr1, int[] arr2, int maxSum) {
        return solve(arr1, arr2, 0, 0, maxSum) - 1;
    }

    private static int solve(int[] arr1, int[] arr2, int sum, int count, int maxSum) {
        if (sum > maxSum) {
            return count;
        }
        if (arr1.length == 0 || arr2.length == 0) {
            return count;
        }

        int ans1 = solve(Arrays.copyOfRange(arr1, 1, arr1.length), arr2, sum + arr1[0], count + 1, maxSum);
        int ans2 = solve(arr1, Arrays.copyOfRange(arr2, 1, arr2.length), sum + arr2[0], count + 1, maxSum);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 2, 4, 6, 1 };
        int[] arr2 = { 2, 1, 8, 5 };

        System.out.println(stacksGame(arr1, arr2, 10));
    }
}
