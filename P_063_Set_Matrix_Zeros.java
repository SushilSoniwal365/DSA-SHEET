public class P_063_Set_Matrix_Zeros {

    // https://leetcode.com/problems/set-matrix-zeroes/description/

    // ? T.C = O(m*n) & S.C = O(m+n).
    public static void setZeroes1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] row_arr = new int[m];
        int[] col_arr = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    row_arr[row] = -1;
                    col_arr[col] = -1;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row_arr[row] == -1 || col_arr[col] == -1) {
                    mat[row][col] = 0;
                }
            }
        }
    }

    // ? T.C = O(m*n) & S.C = O(1).
    public static void setZeroes2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean colSet = false;

        for (int row = 0; row < m; row++) {
            if (mat[row][0] == 0) {
                colSet = true;
            }
            for (int col = 1; col < n; col++) {
                if (mat[row][col] == 0) {
                    mat[row][0] = mat[0][col] = 0;
                }
            }
        }

        for (int row = m - 1; row >= 0; --row) {
            for (int col = n - 1; col > 0; --col) {
                if (mat[row][0] == 0 || mat[0][col] == 0) {
                    mat[row][col] = 0;
                }
            }
            if (colSet) {
                mat[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        setZeroes2(matrix);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
