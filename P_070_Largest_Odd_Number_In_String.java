public class P_070_Largest_Odd_Number_In_String {

    // https://leetcode.com/problems/largest-odd-number-in-string/description/

    // ! T.C = O(n) & S.C = O(1).
    public static String largestOddNumber(String num) {
        int n = num.length();
        int i = n - 1;
        while (i >= 0 && Character.getNumericValue(num.charAt(i)) % 2 == 0) {
            i--;
        }
        return num.substring(0, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("4096"));
    }
}
