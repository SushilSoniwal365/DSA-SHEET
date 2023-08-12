import java.util.Stack;

public class P_129_The_Celebrity_Problem {

    // https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

    // ? T.C = O(n) & S.C = O(n).
    public static int celebrity(int maze[][], int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (maze[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int ans = stack.peek();

        int zeros = 0, ones = 0;
        for (int i = 0; i < n; i++) {
            if (maze[ans][i] == 0)
                zeros++;
            if (maze[i][ans] == 1)
                ones++;
        }

        if (zeros != n || ones != n - 1) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
        System.out.println(celebrity(mat, mat.length));
    }
}
