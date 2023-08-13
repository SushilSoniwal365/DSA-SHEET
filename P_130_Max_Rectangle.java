import java.util.Stack;

public class P_130_Max_Rectangle {

    // https://practice.geeksforgeeks.org/problems/max-rectangle/1

    // ? T.C = O(n) & S.C = O(n).
    public static int maxArea(int mat[][], int n, int m) {
        int area = largestRectangleArea(mat[0], m);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = mat[i][j] + mat[i - 1][j];
                } else {
                    mat[i][j] = 0;
                }
            }
            area = Math.max(area, largestRectangleArea(mat[i], m));
        }
        return area;
    }

    public static int largestRectangleArea(int[] arr, int n) {
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
        int[][] mat = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
        System.out.println(maxArea(mat, 4, 4));
    }
}
