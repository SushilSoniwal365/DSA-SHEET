
public class P_79_Maximum_Gold {

    // https://leetcode.com/problems/path-with-maximum-gold/description/

    // ? T.C = O(m * n * 4^(m * n)) & S.C = O(m*n).
    public static int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        int maxGold = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                maxGold = Math.max(maxGold, checkPath(grid, visited, row, col, 0));
            }
        }

        return maxGold;
    }

    private static int checkPath(int[][] grid, int[][] visited, int row, int col, int goldCollected) {
        if (row == grid.length && col == grid[0].length) {
            return goldCollected;
        }

        if (visited[row][col] == 1 || grid[row][col] == 0) {
            return goldCollected;
        }

        visited[row][col] = 1;
        int totalCurrentGold = 0;

        // right
        if (col < grid[0].length - 1) {
            totalCurrentGold = Math.max(totalCurrentGold,
                    checkPath(grid, visited, row, col + 1, goldCollected + grid[row][col]));
        }

        // down
        if (row < grid.length - 1) {
            totalCurrentGold = Math.max(totalCurrentGold,
                    checkPath(grid, visited, row + 1, col, goldCollected + grid[row][col]));
        }

        // Up
        if (row > 0) {
            totalCurrentGold = Math.max(totalCurrentGold,
                    checkPath(grid, visited, row - 1, col, goldCollected + grid[row][col]));
        }

        // left
        if (col > 0) {
            totalCurrentGold = Math.max(totalCurrentGold,
                    checkPath(grid, visited, row, col - 1, goldCollected + grid[row][col]));
        }

        visited[row][col] = 0;
        return totalCurrentGold;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
        System.out.println(getMaximumGold(grid));
    }
}