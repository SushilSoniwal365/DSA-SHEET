import Classes.ListNode;

public class P_106_Reorder_List {

    // https://leetcode.com/problems/reorder-list/description/

    // ? T.C = O(n) & S.C = O(1).
    public static void reorderList(ListNode head) {
        // Base case: if the list is empty or has only one node.
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list.
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half of the linked list
        ListNode reversedMiddle = reverseLinkedList(middle.next);
        middle.next = null; // Separate the first half and second half

        // Step 3: Merge the two halves of the linked list
        mergeLinkedLists(head, reversedMiddle);
    }

    // * Helper method to find the middle of the linked list.
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // * Helper method to reverse a linked list
    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // * Helper method to merge two linked lists alternatively
    private static void mergeLinkedLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
