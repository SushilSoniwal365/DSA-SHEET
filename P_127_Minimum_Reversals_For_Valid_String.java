import java.util.Stack;

public class P_127_Minimum_Reversals_For_Valid_String {

    // https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1

    // ? T.C = O(n) & S.C = O(n).
    public static int countRev(String str) {
        int len = str.length();
        if (len % 2 != 0)
            return -1;

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        int open = 0, close = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                open++;
            } else {
                close++;
            }
        }

        int rev = (open + 1) / 2 + (close + 1) / 2;
        return rev;
    }

    public static void main(String[] args) {
        String str = "}{{}}{{{";
        System.out.println(countRev(str));
    }
}
