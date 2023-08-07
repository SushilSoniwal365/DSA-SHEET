import java.util.Stack;

public class P_111_Queue_Using_Two_Stacks {

    // https://leetcode.com/problems/implement-queue-using-stacks/description/

    static class MyQueue {
        Stack<Integer> first;
        Stack<Integer> second;

        public MyQueue() {
            first = new Stack<>();
            second = new Stack<>();
        }

        // ! Push data into queue.
        public void push(int x) {
            first.push(x);
        }

        // ! Remove data into queue.
        public int pop() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            int removed = second.pop();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            return removed;
        }

        // ! Remove peek element of queue.
        public int peek() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            int top = second.peek();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            return top;
        }

        // ! Check if queue is empty.
        public boolean empty() {
            return first.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
