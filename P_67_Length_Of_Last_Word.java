public class P_67_Length_Of_Last_Word {

    // https://leetcode.com/problems/length-of-last-word/description/

    // ! T.C = O(n) & S.C = O(1).
    public static int lengthOfLastWord(String s) {
        int idx = s.length() - 1, len = 0;

        // Ignore Trailing Spaces.
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }

        // Calculate The Length.
        while (idx >= 0 && s.charAt(idx) != ' ') {
            len++;
            idx--;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

}
