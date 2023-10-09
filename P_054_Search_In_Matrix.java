public class P_054_Search_In_Matrix {

    // Todo:- Search In A Row & Col Wise Sorted Matrix:- https://leetcode.com/problems/search-a-2d-matrix-ii

    // ? T.C = O(m+n) & S.C = O(1).
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int startingRow = 0, endingCol = n - 1;

        while (startingRow < m && endingCol >= 0) {
            int num = matrix[startingRow][endingCol];

            if (num == target) {
                return true;
            }

            else if (num > target) {
                endingCol--;
            }

            else {
                startingRow++;
            }
        }

        return false;
    }

    // Todo:- Search In A Completely Sorted Matrix:- https://leetcode.com/problems/search-a-2d-matrix

    // * T.C = O(log(m*n)) & S.C = O(1).
    public static boolean searchMatrix2(int[][] mat, int target) {
        int m = mat.length;// No. Of Rows.
        int n = mat[0].length;// No. Of Cols In First Row.

        // Two Imaginary Indexes.
        int start = 0; // First Element Of Matrix.
        int end = m * n - 1;// Last Element Of Matrix.

        // While Loop To Traverse Complete Matrix.
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculating Mid Index.

            int mid_num = mat[mid / n][mid % n]; // Element Present At Mid Index.

            if (mid_num == target)
                return true;
            else if (mid_num > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat1 = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        System.out.println(searchMatrix1(mat1, 13));

        int[][] mat2 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix2(mat2, 20));
    }

}
