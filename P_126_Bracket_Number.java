import java.util.ArrayList;
import java.util.Stack;

public class P_126_Bracket_Number {

    // https://shorturl.at/pEKNO

    // ? T.C = O(n) & S.C = O(n).
    public static ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> ans = new ArrayList<>();
        int open_brackets = 1;
        Stack<Integer> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                ans.add(open_brackets);
                stack.push(open_brackets);
                open_brackets++;
            } else if (ch == ')') {
                ans.add(stack.pop());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "(aa(bdc))p(dee)";
        System.out.println(bracketNumbers(str));
    }
}
