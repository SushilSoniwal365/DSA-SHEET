public class P_066_Valid_Palindrome {

    // https://leetcode.com/problems/valid-palindrome/description/

    // ? T.C = O(n) & S.C = O(n).
    public static boolean isPalindrome1(String s) {
        // Convert string to lowercase;
        s = s.toLowerCase();

        // Skip non-alphanumerics.
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        // Store this in original string.
        s = sb.toString();

        // Reverse the stringbuilder.
        sb.reverse();

        // Convert it into new string.
        String revStr = sb.toString();

        // Compare if palindrome.
        return (s.equals(revStr));
    }

    // * T.C = O(n) & S.C = O(1).
    public static boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left_idx = 0, right_idx = s.length() - 1;
        while (left_idx < right_idx) {
            char left_char = Character.toLowerCase(s.charAt(left_idx));
            char right_char = Character.toLowerCase(s.charAt(right_idx));

            if (!Character.isLetterOrDigit(left_char)) {
                left_idx++;
            } else if (!Character.isLetterOrDigit(right_char)) {
                right_idx--;
            } else if (left_char != right_char) {
                return false;
            } else {
                left_idx++;
                right_idx--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }

}
