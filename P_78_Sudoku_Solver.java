public class P_78_Sudoku_Solver {

    // https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1

    // ? T.C = O(9^N*N) & S.C = O(N*N).

    // Todo:- Function to solve the Sudoku puzzle using backtracking.
    public static boolean SolveSudoku(int board[][]) {
        int n = board.length;
        int emptyRow = -1, emptyCol = -1;
        boolean isEmpty = true;

        // Find an empty cell in the Sudoku grid.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // If all cells are filled, the Sudoku is solved.
        if (isEmpty) {
            return true;
        }

        // Try numbers from 1 to 9 for the empty cell and backtrack.
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, emptyRow, emptyCol, num)) {
                board[emptyRow][emptyCol] = num;
                if (SolveSudoku(board)) {
                    return true;
                } else {
                    // If placing the number num doesn't lead to a solution, backtrack.
                    board[emptyRow][emptyCol] = 0;
                }
            }
        }
        return false;
    }

    // * Function to check if it's safe to place num at position (row, col).
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        int n = board.length;

        // Check if num is already present in the row or column.
        for (int i = 0; i < n; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check if num is already present in the 3x3 subgrid.
        int sqrt = (int) Math.sqrt(n);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // * Function to print the Sudoku grid.
    public static void printGrid(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] board = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        SolveSudoku(board);
        printGrid(board);
    }
}
