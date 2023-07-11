import java.util.ArrayList;
import java.util.List;

public class P_18_Pascal_Triangle_1 {

    // https://leetcode.com/problems/pascals-triangle/description/

    // ? T.C = O(n^2) & S.C = O(n^2).
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // * Base case: If numRows is 0, return an empty triangle
        if (numRows == 0) {
            return result;
        }

        // * First row of Pascal's Triangle
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        // * Generate the remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            // * Fill the current row based on the values from the previous row
            List<Integer> previousRow = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                int sum = previousRow.get(j - 1) + previousRow.get(j);
                currentRow.add(sum);
            }

            currentRow.add(1);
            result.add(currentRow);
        }

        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generate(numRows);

        // * Printing the triangle
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
