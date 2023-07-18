import java.util.Arrays;

public class P_65_Reverse_String {

    // https://leetcode.com/problems/reverse-string/description/

    // ! T.C = O(n) & S.C = O(1).
    public static void reverseString(char[] ch) {
        int start_idx = 0, end_idx = ch.length - 1;
        while (start_idx < end_idx) {
            char temp = ch[start_idx];
            ch[start_idx] = ch[end_idx];
            ch[end_idx] = temp;
            start_idx++;
            end_idx--;
        }
    }

    public static void main(String[] args) {
        char[] ch = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(ch);
        System.out.println(Arrays.toString(ch));
    }

}
