import java.util.ArrayList;
import java.util.List;

public class P_076_N_Queens_1 {

    // https://leetcode.com/problems/n-queens/

    // * T.C = O(N * N!) & S.C = O(N*N).
    public static List<List<String>> solveNQueens(int n) {
        // Resultant List.
        List<List<String>> res = new ArrayList<>();

        // N*N Board.
        char[][] board = new char[n][n];

        // Initialize board with a single dot.
        for (int row_idx = 0; row_idx < n; row_idx++) {
            for (int col_idx = 0; col_idx < n; col_idx++) {
                board[row_idx][col_idx] = '.';
            }
        }

        // Calling Function That Will Place The Queens.
        placeQueens(0, board, n, res);

        return res;
    }

    // ? Function To Place Queens On A N*N ChessBoard.
    private static void placeQueens(int col_idx, char[][] board, int n, List<List<String>> res) {
        // Base Case:- We are at the last column.
        if (col_idx == n) {
            res.add(construct(board));
            return;
        }

        for (int row_idx = 0; row_idx < n; row_idx++) {
            if (isSafeToPlaceQueen(board, row_idx, col_idx)) {
                board[row_idx][col_idx] = 'Q'; // Place A Queen.
                placeQueens(col_idx + 1, board, n, res); // Recursive Call For Further Columns.
                board[row_idx][col_idx] = '.'; // BackTrack
            }
        }
    }

    // ? Function To Check Whether An Index Is Safe Or Not For A Queen.
    private static boolean isSafeToPlaceQueen(char[][] board, int row_idx, int col_idx) {

        int row = row_idx;
        int col = col_idx;

        // Check Upper-Left-Diagonal.
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = row_idx;
        col = col_idx;

        // Check Left.
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = row_idx;
        col = col_idx;

        // Check Down-Left-Diagonal.
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    // ? Function To Construct Our Board.
    private static List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);
            ans.add(str);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
