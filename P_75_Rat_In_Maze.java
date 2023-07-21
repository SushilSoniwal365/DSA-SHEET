import java.util.ArrayList;

public class P_75_Rat_In_Maze {

    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

    public static ArrayList<String> findPath(int[][] maze, int n) {
        // Check If We Can't Reach The Target.
        if (maze[n - 1][n - 1] == 0) {
            ArrayList<String> sol = new ArrayList<String>();
            sol.add("-1");
            return sol;
        }
        return solve("", maze, n, 0, 0);
    }

    private static ArrayList<String> solve(String ans, int[][] maze, int n, int row, int col) {
        // Base Case.
        if (row == n - 1 && col == n - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        // Obstacle Case.
        if (maze[row][col] == 0) {
            return new ArrayList<>();
        }

        // Consider Cell In Our Path.
        maze[row][col] = 0;
        ArrayList<String> local = new ArrayList<>();

        // To Travel Down.
        if (row < n - 1) {
            local.addAll(solve(ans + "D", maze, n, row + 1, col));
        }

        // To Travel Right.
        if (col < n - 1) {
            local.addAll(solve(ans + "R", maze, n, row, col + 1));
        }

        // To Travel Up.
        if (row > 0) {
            local.addAll(solve(ans + "U", maze, n, row - 1, col));
        }

        // To Travel Left.
        if (col > 0) {
            local.addAll(solve(ans + "L", maze, n, row, col - 1));
        }

        // * BackTrack:- Remove The Changes That We Were Made Previously.
        maze[row][col] = 1;
        return local;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        System.out.println(findPath(maze, maze.length));
    }
}
