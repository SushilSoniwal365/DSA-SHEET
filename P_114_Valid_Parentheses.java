import java.util.Stack;

public class P_114_Valid_Parentheses {

    // https://leetcode.com/problems/valid-parentheses/description/

    // ? T.C = O(n) & S.C = O(n).
    public static boolean isValid(String s) {
        // Create a stack to track opening parentheses
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the input string
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // If it's an opening parenthesis, push onto the stack
                stack.push(c);
            } else {
                // If it's a closing parenthesis, check if it matches the top of the stack
                if (stack.isEmpty()) {
                    return false; // No matching opening parenthesis
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false; // Mismatched parenthesis
                }
            }
        }

        // After looping, the stack should be empty if all parentheses are matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "([)]";
        if (isValid(str)) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Unvalid Parentheses");
        }
    }
}
