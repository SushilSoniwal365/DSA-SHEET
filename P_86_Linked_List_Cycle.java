class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class P_86_Linked_List_Cycle {

    // https://leetcode.com/problems/linked-list-cycle/description/

    // ? T.C = O(n) & S.C = O(1).
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // Create a linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Cycle back to node1

        System.out.println(hasCycle(head));
    }

}
