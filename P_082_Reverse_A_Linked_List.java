import Classes.ListNode;

public class P_082_Reverse_A_Linked_List {

    // https://leetcode.com/problems/reverse-linked-list/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        while (currNode != null) {
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedHead = reverseList(head);
        // Printing the reversed linked list.
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}
