public class P_068_Remove_Outermost_Parentheses {

    // https://leetcode.com/problems/remove-outermost-parentheses/description/

    // ! T.C = O(n) & S.C = O(n).
    public static String removeOuterParentheses(String str) {
        int len = str.length(), idx = 0;
        int open = 0, close = 0;
        String res = "";

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '(')
                open++;
            else
                close++;

            if (open == close) {
                res += str.substring(idx + 1, i);
                idx = i + 1;
                open = close = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
