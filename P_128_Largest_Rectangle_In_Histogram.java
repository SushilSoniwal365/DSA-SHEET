import java.util.Stack;

public class P_128_Largest_Rectangle_In_Histogram {

    // https://leetcode.com/problems/largest-rectangle-in-histogram/description/

    // ? T.C = O(n) & S.C = O(n).
    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        // * Initialize arrays with default values
        for (int i = 0; i < n; i++) {
            prevSmaller[i] = -1;
            nextSmaller[i] = n;
        }

        // * Find previous smaller element for each element
        findPrevSmaller(arr, prevSmaller);

        // * Find next smaller element for each element
        findNextSmaller(arr, nextSmaller);

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static void findPrevSmaller(int[] arr, int[] prevSmaller) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    }

    private static void findNextSmaller(int[] arr, int[] nextSmaller) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int maxArea = largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + maxArea);
    }
}
