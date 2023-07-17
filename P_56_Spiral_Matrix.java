import java.util.ArrayList;
import java.util.List;

public class P_56_Spiral_Matrix {

    // https://leetcode.com/problems/spiral-matrix/description/

    // ! T.C = O(m*n) & S.C = O(1).
    public static List<Integer> spiralOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        int sr = 0, sc = 0, er = m - 1, ec = n - 1;

        while (sr <= er && sc <= ec) {

            // * Print First Row.
            for (int i = sc; i <= ec; i++) {
                ans.add(mat[sr][i]);
            }
            sr++;

            // * Print Last Col.
            for (int i = sr; i <= er; i++) {
                ans.add(mat[i][ec]);
            }
            ec--;

            // * Print Ending Row.
            if (sr <= er) {
                for (int i = ec; i >= sc; --i) {
                    ans.add(mat[er][i]);
                }
            }
            er--;

            // * Print Starting Col.
            if (sc <= ec) {
                for (int i = er; i >= sr; --i) {
                    ans.add(mat[i][sc]);
                }
            }
            sc++;

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(spiralOrder(mat));
    }
}
