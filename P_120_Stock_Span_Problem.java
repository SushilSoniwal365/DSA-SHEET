import java.util.Stack;

public class P_120_Stock_Span_Problem {

    // https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

    // ? T.C = O(n) & S.C = O(n).
    public static int[] calculateSpan(int[] prices, int n) {
        int[] span = new int[n]; // Array to store the stock spans
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices

        stack.push(0); // Initialize the stack with the index of the first element
        span[0] = 1; // The span of the first element is always 1

        for (int i = 1; i < n; i++) {
            // Pop elements from the stack until a greater price is encountered
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            // Calculate the span for the current element based on the stack's top element
            if (stack.isEmpty()) {
                span[i] = i + 1; // If stack is empty, all previous elements are smaller
            } else {
                span[i] = i - stack.peek();
            }

            stack.push(i); // Push the current index onto the stack
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int n = prices.length;

        int[] span = calculateSpan(prices, n);

        System.out.println("Prices: " + java.util.Arrays.toString(prices));
        System.out.println("Spans: " + java.util.Arrays.toString(span));
    }
}
