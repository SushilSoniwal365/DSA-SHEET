import Classes.ListNode;

public class P_98_Remove_Nth_Node_From_End_Of_List {

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;

        for (int i = 1; i <= n; ++i)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode newHead = removeNthFromEnd(head, 3);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
