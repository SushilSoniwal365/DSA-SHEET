import java.util.Arrays;

public class P_58_Spiral_Matrix_2 {

    // https://leetcode.com/problems/spiral-matrix-ii/description/

    // ? T.C = O(n*n) & S.C = O(1).
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;

        int sr = 0, sc = 0, er = n - 1, ec = n - 1;

        while (sr <= er && sc <= ec) {

            // * Print First Row.
            for (int i = sc; i <= ec; i++) {
                ans[sr][i] = num++;
            }
            sr++;

            // * Print Last Col.
            for (int i = sr; i <= er; i++) {
                ans[i][ec] = num++;
            }
            ec--;

            // * Print Ending Row.
            if (sr <= er) {
                for (int i = ec; i >= sc; --i) {
                    ans[er][i] = num++;
                }
            }
            er--;

            // * Print Starting Col.
            if (sc <= ec) {
                for (int i = er; i >= sr; --i) {
                    ans[i][sc] = num++;
                }
            }
            sc++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);

        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
}
