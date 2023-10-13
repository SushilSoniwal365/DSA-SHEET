import Classes.ListNode;

public class P_099_Merge_Two_Sorted_LinkedList {

    // https://leetcode.com/problems/merge-two-sorted-lists/description/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists until either one becomes null
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                // Append the smaller value node to the merged list
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes of the non-empty list (if any)
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the merged sorted list, skipping the dummy node
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(15);
        head1.next.next.next.next = new ListNode(16);
        head1.next.next.next.next.next = new ListNode(24);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(8);
        head2.next.next.next = new ListNode(15);
        head2.next.next.next.next = new ListNode(16);
        head2.next.next.next.next.next = new ListNode(27);

        ListNode mergedList = mergeTwoLists(head1, head2);
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
