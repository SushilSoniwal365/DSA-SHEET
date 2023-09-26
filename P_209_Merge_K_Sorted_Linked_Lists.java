import java.util.PriorityQueue;

import Classes.ListNode;

public class P_209_Merge_K_Sorted_Linked_Lists {

    // https://leetcode.com/problems/merge-k-sorted-lists/description/

    // ? T.C = O(n*logk) & S.C = O(k).
    public static ListNode mergeKLists(ListNode[] lists) {
        // Create a min-heap (PriorityQueue) to store the heads of the linked lists
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the initial nodes of each linked list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Create a dummy head and a pointer to the current node
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process each node from the min-heap
        while (!minHeap.isEmpty()) {
            // Get the node with the smallest value from the min-heap
            ListNode smallest = minHeap.poll();

            // Add it to the result list
            current.next = smallest;
            current = current.next;

            // Move to the next node in the original list
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        ListNode result = mergeKLists(lists);

        // Print the merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
