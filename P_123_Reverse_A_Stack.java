import java.util.Stack;

public class P_123_Reverse_A_Stack {

    // https://practice.geeksforgeeks.org/problems/reverse-a-stack/1

    // ? T.C = O(n) & S.C = O(n).
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int num = stack.pop();
        reverse(stack);
        insertAtBottom(stack, num);
    }

    // * Insert an element at the bottom of the stack.
    public static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.add(x);
            return;
        }
        int num = stack.pop();
        insertAtBottom(stack, x);
        stack.push(num);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(5);

        reverse(stack);
        System.out.println(stack);
    }
}
