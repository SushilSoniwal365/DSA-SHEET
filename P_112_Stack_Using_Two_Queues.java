import java.util.LinkedList;
import java.util.Queue;

public class P_112_Stack_Using_Two_Queues {

    // https://leetcode.com/problems/implement-stack-using-queues/description/

    static class MyStack {
        Queue<Integer> first;
        Queue<Integer> second;

        public MyStack() {
            first = new LinkedList<>();
            second = new LinkedList<>();
        }

        public void push(int x) {
            while (!first.isEmpty()) {
                second.add(first.poll());
            }
            first.add(x);
            while (!second.isEmpty()) {
                first.add(second.poll());
            }
        }

        public int pop() {
            return first.poll();
        }

        public int top() {
            return first.peek();
        }

        public boolean empty() {
            return first.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
