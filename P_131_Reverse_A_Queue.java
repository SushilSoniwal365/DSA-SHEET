import java.util.LinkedList;
import java.util.Queue;

public class P_131_Reverse_A_Queue {

    // https://practice.geeksforgeeks.org/problems/queue-reversal/1

    // ? T.C = O(n) & S.C = O(n).
    public static Queue<Integer> rev(Queue<Integer> q) {
        reverse(q);
        return q;
    }

    private static void reverse(Queue<Integer> queue) {
        if (queue.size() == 1) {
            return;
        }
        int top = queue.poll();
        rev(queue);
        queue.add(top);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(4);
        queue.add(3);
        queue.add(1);
        queue.add(10);
        queue.add(2);
        queue.add(6);

        queue = rev(queue);
        System.out.println(queue);
    }
}
