import java.util.Stack;

public class P_115_Minimum_Parentheses_To_Add {

    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

    // ? T.C = O(n) & S.C = O(n).
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
    }
}
