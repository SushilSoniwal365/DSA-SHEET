public class P_077_N_Queens_2 {

    // https://leetcode.com/problems/n-queens-ii/description/

    public static int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];

        if (n == 1) {
            return 1;
        }
        return countWays(board, 0);
    }

    // ? Function To Count Total Number Of Solutions Possible.
    private static int countWays(boolean[][] board, int col) {
        if (col == board.length) {
            return 1;
        }
        int result = 0;

        for (int row = 0; row < board.length; row++) {
            if (isSafeToPlaceQueen(board, row, col)) {
                board[row][col] = true; // Place A Queen.
                result += countWays(board, col + 1); // Recursive Call For Further Columns.
                board[row][col] = false; // BackTrack
            }
        }

        return result;
    }

    // ? Function To Check Whether An Index Is Safe Or Not For A Queen.
    private static boolean isSafeToPlaceQueen(boolean[][] board, int row_idx, int col_idx) {

        int row = row_idx;
        int col = col_idx;

        // Check Upper-Left-Diagonal.
        while (row >= 0 && col >= 0) {
            if (board[row][col]) {
                return false;
            }
            row--;
            col--;
        }

        row = row_idx;
        col = col_idx;

        // Check Left.
        while (col >= 0) {
            if (board[row][col]) {
                return false;
            }
            col--;
        }

        row = row_idx;
        col = col_idx;

        // Check Down-Left-Diagonal.
        while (row < board.length && col >= 0) {
            if (board[row][col]) {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
