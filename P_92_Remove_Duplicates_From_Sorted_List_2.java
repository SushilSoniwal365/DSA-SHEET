import Classes.ListNode;

public class P_92_Remove_Duplicates_From_Sorted_List_2 {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Move curr to the last duplicate node
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // If there are duplicates, skip all of them
            if (prev.next != curr) {
                prev.next = curr.next;
            } else {
                // Otherwise, move both pointers
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode newHead = deleteDuplicates(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
