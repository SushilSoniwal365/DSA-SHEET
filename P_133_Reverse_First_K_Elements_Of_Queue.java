import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_133_Reverse_First_K_Elements_Of_Queue {

    // https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1

    // ? T.C = O(n) & S.C = O(k).
    public static Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        while (!stack.empty()) {
            queue.add(stack.pop());
        }

        int t = queue.size() - k;
        while (t > 0) {
            queue.add(queue.remove());
            t--;
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(modifyQueue(queue, 3));
    }
}
