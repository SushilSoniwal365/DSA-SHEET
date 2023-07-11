public class P_22_Valid_Perfect_Square {

    // https://leetcode.com/problems/valid-perfect-square

    // ? T.C = O(n) & S.C = O(1).
    public static boolean isPerfectSquare1(int num) {
        if (num < 1) {
            return false;
        }
        long i = 1;
        while (i * i < num) {
            i++;
        }
        return i * i == num;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static boolean isPerfectSquare2(int num) {
        if (num < 1) {
            return false;
        }
        long left = 1, right = num, mid, square;
        while (left <= right) {
            mid = left + (right - left) / 2;
            square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare2(17));
    }

}
