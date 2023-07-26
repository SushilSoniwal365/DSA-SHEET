public class P_90_Delete_The_Middle_Node_Of_A_Linked_List {

    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head, prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        deleteMiddle(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
