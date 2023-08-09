import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_116_Previous_Smallest_Element {

    // https://rb.gy/kzb3d

    // ? T.C = O(n) & S.C = O(n).
    public static List<Integer> leftSmaller(int n, int arr[]) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            // * Pop elements from stack until a smaller element is found
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(stack.peek());
            }
            stack.push(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 0, 3, 4, 5 };
        List<Integer> res = leftSmaller(arr.length, arr);
        System.out.println(res);
    }
}
