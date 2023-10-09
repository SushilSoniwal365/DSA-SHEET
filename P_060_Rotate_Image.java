public class P_060_Rotate_Image {

    // https://leetcode.com/problems/rotate-image/description/

    // ! T.C = O(n*n) & S.C = O(1)
    public static void rotate(int[][] mat) {
        int n = mat.length;

        // * Transpose Matrix.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // * Reflect The Image.
        for (int i = 0; i < n; i++) {
            int sc = 0, ec = n - 1;
            while (sc < ec) {
                int temp = mat[i][sc];
                mat[i][sc] = mat[i][ec];
                mat[i][ec] = temp;
                sc++;
                ec--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(mat);

        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
