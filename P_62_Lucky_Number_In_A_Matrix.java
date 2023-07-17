import java.util.ArrayList;
import java.util.List;

public class P_62_Lucky_Number_In_A_Matrix {

    // https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

    // ! T.C = O(m*n) & S.C = O(m).
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int min_col_idx = findMinInRow(matrix, row);
            int min_val = matrix[row][min_col_idx];

            if (isMaxInCol(matrix, min_col_idx, min_val)) {
                ans.add(min_val);
            }
        }

        return ans;
    }

    // * Find the index of the minimum value in the given row of the matrix.
    private static int findMinInRow(int[][] mat, int row) {
        int min_idx = 0, min_num = mat[row][min_idx];
        for (int col = 0; col < mat[row].length; col++) {
            if (mat[row][col] < min_num) {
                min_num = mat[row][col];
                min_idx = col;
            }
        }
        return min_idx;
    }

    // * Checks if the given value is the maximum value in its column
    private static boolean isMaxInCol(int[][] mat, int col, int num) {
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > num) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
        System.out.println(luckyNumbers(matrix));
    }
}
