public class P_064_String_Basics {

    // Todo:- Calculate Length Of A String.
    public static int calculateLength(String str) {
        int len = 0;
        char[] characters = str.toCharArray();

        for (char ch : characters) {
            len++;
        }
        return len;
    }

    // Todo:- Reverse A String.
    public static String reverseWord(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; --i) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Todo:- Check Palindrome String.
    public static boolean isPalindrome(String str1) {
        String rev_str = reverseWord(str1);
        return (rev_str.equals(str1));
    }

    public static void main(String[] args) {
        System.out.println(calculateLength("Sushil"));
        System.out.println(reverseWord("Sushil"));
        System.out.println(isPalindrome("racecar"));
    }
}
