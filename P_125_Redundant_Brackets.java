import java.util.Stack;

public class P_125_Redundant_Brackets {

    // https://shorturl.at/IPSW0

    // ? T.C = O(n) & S.C = O(n).
    public static int removeBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    boolean isRedundant = true;

                    while (stack.peek() != '(') {
                        char top = stack.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/') {
                            isRedundant = false;
                        }
                        stack.pop();
                    }

                    if (isRedundant)
                        return 1;
                    stack.pop();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "(a*(a+b))";
        if (removeBrackets(str) == 1) {
            System.out.println("Contains redundant brackets");
        } else {
            System.out.println("Not-Contain redundant brackets");
        }
    }
}
