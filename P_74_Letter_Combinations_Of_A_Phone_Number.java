import java.util.ArrayList;
import java.util.List;

public class P_74_Letter_Combinations_Of_A_Phone_Number {

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number

    // * T.C = O(n) & S.C = O(n).
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            // If the input string is empty, there are no possible combinations, so return an empty list.
            return new ArrayList<>();
        }
        // Call the 'solve' function with an empty answer and the input string.
        return solve("", digits);
    }

    private static List<String> solve(String ans, String str) {
        // Base Case: If the input string is empty, we have reached the end of a
        // combination.
        if (str.isEmpty()) {
            // Create a new list to store the final combination.
            ArrayList<String> res = new ArrayList<>();
            // Add the current combination to the result list.
            res.add(ans);
            return res;
        }

        // Get the digit at the beginning of the input string.
        int digit = str.charAt(0) - '0';

        // Calculate the start and end indices based on the digit.
        int start = (digit - 2) * 3;
        int end = (digit - 1) * 3;

        // Special cases for digits 7, 8, and 9 due to different number-letter mappings.
        if (digit == 7) {
            end = ((digit - 1) * 3) + 1;
        }
        if (digit == 8) {
            start = ((digit - 2) * 3) + 1;
            end = ((digit - 1) * 3) + 1;
        }
        if (digit == 9) {
            start = ((digit - 2) * 3) + 1;
            end = ((digit - 1) * 3) + 2;
        }

        // Create a list to store the combinations for the current digit.
        ArrayList<String> local = new ArrayList<>();

        for (int i = start; i < end; i++) {
            // Get corresponding character for the current letter based on the ASCII value.
            char ch = (char) ('a' + i);
            // Recursively call 'solve' with the updated answer and the remaining substring.
            local.addAll(solve(ans + ch, str.substring(1)));
        }
        return local;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("79"));
    }
}
