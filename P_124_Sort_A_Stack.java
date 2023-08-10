import java.util.Stack;

public class P_124_Sort_A_Stack {

    // https://practice.geeksforgeeks.org/problems/sort-a-stack/1

    // ? T.C = O(n^2) & S.C = O(n).
    public static Stack<Integer> sort(Stack<Integer> stack) {
        // Start the sorting process
        solve(stack);
        return stack;
    }

    // * Recursive function to sort the stack
    private static void solve(Stack<Integer> stack) {
        // Base case: Stack is empty, nothing to do
        if (stack.isEmpty()) {
            return;
        }

        // Pop an element from the stack
        int num = stack.pop();

        // Recursively sort the remaining elements
        solve(stack);

        // Insert the popped element in its correct position
        insert(stack, num);
    }

    // * Recursive function to insert an element at the correct position in stack.
    private static void insert(Stack<Integer> stack, int num) {
        // Base case: Stack is empty or current top element is smaller, push element.
        if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < num)) {
            stack.push(num);
            return;
        }

        // Pop elements until a smaller element is found, then insert
        int n = stack.pop();
        insert(stack, num);

        // Push the previously popped element back into the stack
        stack.push(n);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        Stack<Integer> sortedStack = sort(stack);

        // Printing the sorted stack
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
}
