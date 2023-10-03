import java.util.Scanner;

public class P_021_Square_Root_Of_X {

    // https://leetcode.com/problems/sqrtx

    // ? T.C = O(n) & S.C = O(1).
    public static int mySqrt1(int x) {
        if (x < 2) {
            return x;
        }

        int ans = 1;
        for (int i = 2; i <= x / 2; i++) {
            if (i <= x / i) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int mySqrt2(int x) {
        if (x < 2) {
            return x;
        }

        int s = 2, e = x / 2;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return e;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(mySqrt2(x));
        in.close();
    }

}
