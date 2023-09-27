import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_212_Top_K_Frequent_Elements {

    // https://leetcode.com/problems/top-k-frequent-elements/description/

    // ? T.C = O(n*logk) & S.C = O(n+k).
    public static int[] topKFrequent(int[] nums, int k) {
        // Create a frequency map to count the occurrences of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a min-heap (priority queue) to keep track of the K most frequent
        // elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        // Iterate through the frequency map and add elements to the min-heap
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element if heap size exceeds K
            }
        }

        // Create the result array and fill it with the K most frequent elements from
        // the min-heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
}
