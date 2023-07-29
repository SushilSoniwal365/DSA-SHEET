import Classes.ListNode;

public class P_91_Rotate_List {

    // https://leetcode.com/problems/rotate-list/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Find the length of the list and the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;

        // Calculate the effective rotation amount (less than the length)
        k = k % length;

        // Find the new tail.
        ListNode newLast = head;
        for (int i = 0; i < length - k - 1; i++) {
            newLast = newLast.next;
        }

        // Update pointers to rotate the list
        head = newLast.next;
        newLast.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = rotateRight(head, 2);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
