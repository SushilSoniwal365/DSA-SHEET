import java.util.Arrays;

public class P_61_Determine_Whether_Matrix_Can_Be_Obtain_By_Rotation {

    // https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/

    // ! T.C = O(n*n) & S.C = O(n*n).
    public static boolean findRotation1(int[][] mat, int[][] target) {
        int n = mat.length;

        // * Rotate 90 Degree.
        int[][] res_90 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res_90[i][j] = mat[n - 1 - j][i];
            }
        }

        // * Rotate 180 Degree.
        int[][] res_180 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res_180[i][j] = res_90[n - 1 - j][i];
            }
        }

        // * Rotate 270 Degree.
        int[][] res_270 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res_270[i][j] = res_180[n - 1 - j][i];
            }
        }

        return Arrays.deepEquals(target, res_90) || Arrays.deepEquals(target, res_180)
                || Arrays.deepEquals(target, res_270) || Arrays.deepEquals(target, mat);
    }

    // ! T.C = O(n*n) & S.C = O(1).
    public static boolean findRotation2(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    // Rotate The Matrix.
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0, }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] target = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(findRotation1(mat, target));
    }
}
