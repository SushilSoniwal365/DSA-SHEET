import Classes.ListNode;

public class P_104_Reverse_Linked_List_2 {

    // https://leetcode.com/problems/reverse-linked-list-ii/description/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Find the node before the sublist to be reversed
        ListNode preStart = dummy;
        for (int i = 1; i < left; i++) {
            preStart = preStart.next;
        }

        // Separate the sublist to be reversed
        ListNode start = preStart.next;
        ListNode end = start;

        // Move 'end' pointer right-left steps forward to get the node after the sublist
        for (int i = 0; i < right - left; i++) {
            end = end.next;
        }

        // Cut off the sublist to be reversed from the main list
        ListNode postEnd = end.next;
        end.next = null;

        // Reverse the sublist
        reverse(start);

        // Connect the reversed sublist back to the main list
        preStart.next = end;
        start.next = postEnd;
        return dummy.next;
    }

    // Helper method to reverse a linked list
    private static void reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(15);
        head1.next.next.next.next = new ListNode(16);
        head1.next.next.next.next.next = new ListNode(24);

        ListNode current = reverseBetween(head1, 2, 4);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
