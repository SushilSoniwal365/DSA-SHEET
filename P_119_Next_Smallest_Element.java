import java.util.Arrays;
import java.util.Stack;

public class P_119_Next_Smallest_Element {

    // https://shorturl.at/ekKQ5

    // ? T.C = O(n) & S.C = O(n).
    public static int[] help_classmate(int arr[], int n) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            while (!stack.isEmpty() && stack.peek() >= num) {
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
        int[] arr = { 1, 5, 0, 3, 4, 5 };
        System.out.println(Arrays.toString(help_classmate(arr, arr.length)));
    }
}
