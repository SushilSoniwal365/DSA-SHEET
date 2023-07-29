import Classes.ListNode;

public class P_100_Sort_List {

    // https://leetcode.com/problems/sort-list/description/

    // ? T.C = O(nlogn) & S.C = O(1).
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(half);
        return merge(l1, l2);
    }

    // Todo:- Merge Both The Lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
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

        ListNode current = sortList(head1);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
