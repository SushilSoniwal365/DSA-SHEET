public class P_055_Row_With_Minimum_Number_Of_1s {

    // https://bit.ly/3Tn6rO2

    // * T.C = O(n*m) & S.C = O(1).
    public static int minRow(int n, int m, int mat[][]) {
        int min_row = 0, min_ones = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    c++;
                }
            }
            if (c < min_ones) {
                min_ones = c;
                min_row = i;
            }
        }
        return min_row + 1;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };
        System.out.println(minRow(mat.length, mat[0].length, mat));
    }
}
