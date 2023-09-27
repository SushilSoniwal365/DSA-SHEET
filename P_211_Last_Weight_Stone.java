import java.util.Comparator;
import java.util.PriorityQueue;

public class P_211_Last_Weight_Stone {

    // https://leetcode.com/problems/last-stone-weight/description/

    // ? T.C = O(n*logn) & S.C = O(n).
    public static int lastStoneWeight(int[] stones) {
        // Create a max heap (PriorityQueue) to store stones with maximum weight at the
        // top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Perform the stone smashing operation until only one stone is left
        while (maxHeap.size() > 1) {
            int firstStone = maxHeap.poll(); // Get the heaviest stone
            int secondStone = maxHeap.poll(); // Get the second heaviest stone

            // Calculate the resulting stone weight after smashing
            int smashedStone = Math.abs(firstStone - secondStone);

            // Add the smashed stone back to the max heap
            maxHeap.offer(smashedStone);
        }

        // If there's a stone left, return its weight; otherwise, return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(arr));
    }
}
