import Classes.ListNode;

public class P_93_Linked_List_Cycle_2 {

    // https://leetcode.com/problems/linked-list-cycle-ii/description/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode detectCycle(ListNode head) {
        // Step 1: Find the meeting point of the slow and fast pointers (if there's a
        // cycle)
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Cycle detected, now find the cycle's start node
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start; // Return the node where the cycle starts
            }
        }

        // If no cycle is found, return null
        return null;
    }

    public static void main(String[] args) {
        // Create a sample linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Cycle back to node1

        // Call the detectCycle method to find the node where the cycle starts
        ListNode cycleStartNode = detectCycle(head);

        // Print the result
        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with value: " + cycleStartNode.val);
        } else {
            System.out.println("No cycle found in the linked list.");
        }
    }
}
