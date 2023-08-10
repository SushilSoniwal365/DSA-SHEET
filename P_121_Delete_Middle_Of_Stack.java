import java.util.Stack;

public class P_121_Delete_Middle_Of_Stack {

    // practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1

    // ? T.C = O(n) & S.C = O(n).
    public static void deleteMid(Stack<Integer> st, int sizeOfStack) {
        solve(st, 0, sizeOfStack);
    }

    // * Helper function to delete middle element.
    public static void solve(Stack<Integer> stack, int count, int size) {
        if (count == size / 2) {
            stack.pop();
            return;
        }

        int num = stack.pop();
        solve(stack, count + 1, size);
        stack.push(num);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(5);

        deleteMid(stack, stack.size());

        System.out.println(stack);
    }
}
