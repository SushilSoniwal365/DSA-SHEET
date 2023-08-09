import java.util.Arrays;
import java.util.Stack;

public class P_118_Next_Largest_Element {

    // https://shorturl.at/nAOV9

    // ? T.C = O(n) & S.C = O(n).
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            long num = arr[i];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 5, 0, 3, 4, 5 };
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }
}
