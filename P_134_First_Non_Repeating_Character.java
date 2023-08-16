import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P_134_First_Non_Repeating_Character {

    // https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1

    // ? T.C = O(n) & S.C = O(n).
    public static String FirstNonRepeating(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            queue.add(ch);

            while (!queue.isEmpty()) {
                if (map.get(queue.peek()) > 1) {
                    queue.remove();
                } else {
                    ans.append(queue.peek());
                    break;
                }
            }

            if (queue.isEmpty()) {
                ans.append("#");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(FirstNonRepeating("aabc"));
    }
}
