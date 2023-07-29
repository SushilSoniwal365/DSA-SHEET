import Classes.ListNode;

public class P_102_Add_Two_Numbers {

    // https://leetcode.com/problems/add-two-numbers/description/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode newNode = head;
        int carry = 0;
        while ((l1 != null) || (l2 != null)) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            newNode.next = new ListNode(sum % 10);
            newNode = newNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            newNode.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        ListNode mergedList = addTwoNumbers(head1, head2);
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
