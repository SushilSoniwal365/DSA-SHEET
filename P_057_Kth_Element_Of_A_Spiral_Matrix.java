import java.util.ArrayList;

public class P_057_Kth_Element_Of_A_Spiral_Matrix {

    // https://bit.ly/40i48xT

    // ! T.C = O(m*n) & S.C = O(m*n).
    public static int findK1(int[][] mat, int m, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sr = 0, er = m - 1, sc = 0, ec = n - 1;

        while (sr <= er && sc <= ec) {

            // * Check In First Row.
            for (int i = sc; i <= ec; i++) {
                ans.add(mat[sr][i]);
            }
            sr++;

            // * Check In Last Col.
            for (int i = sr; i <= er; i++) {
                ans.add(mat[i][ec]);
            }
            ec--;

            // * Check In Ending Row.
            if (sr <= er) {
                for (int i = ec; i >= sc; i--) {
                    ans.add(mat[er][i]);
                }
            }
            er--;

            // * Check In Starting Col.
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    ans.add(mat[i][sc]);
                }
            }
            sc++;
        }

        return ans.get(k - 1);
    }

    // ! T.C = O(m*n) & S.C = O(1).
    public static int findK2(int[][] mat, int m, int n, int k) {
        int sr = 0, er = m - 1, sc = 0, ec = n - 1;

        int count = 0;

        while (sr <= er && sc <= ec) {

            // * Check In First Row.
            for (int i = sc; i <= ec; i++) {
                count++;
                if (count == k)
                    return mat[sr][i];
            }
            sr++;

            // * Check In Last Col.
            for (int i = sr; i <= er; i++) {
                count++;
                if (count == k)
                    return (mat[i][ec]);
            }
            ec--;

            // * Check In Ending Row.
            if (sr <= er) {
                for (int i = ec; i >= sc; i--) {
                    count++;
                    if (count == k)
                        return (mat[er][i]);
                }
            }
            er--;

            // * Check In Starting Col.
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    count++;
                    if (count == k)
                        return (mat[i][sc]);
                }
            }
            sc++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(findK2(mat, mat.length, mat[0].length, 4));
    }
}
