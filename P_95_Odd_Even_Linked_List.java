import Classes.ListNode;

public class P_95_Odd_Even_Linked_List {

    // https://leetcode.com/problems/odd-even-linked-list/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode oddEvenList(ListNode head) {
        // Check for empty list or a list with only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize two pointers for odd and even nodes
        ListNode oddHead = head; // Pointer to the first odd node
        ListNode evenHead = head.next; // Pointer to the first even node
        ListNode oddPtr = oddHead; // Pointer to track odd nodes
        ListNode evenPtr = evenHead; // Pointer to track even nodes

        // Traverse the list, rearranging odd and even nodes
        while (evenPtr != null && evenPtr.next != null) {
            // Connect odd node to the next odd node
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next; // Move oddPtr to the next odd node
            // Connect even node to the next even node
            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next; // Move evenPtr to the next even node
        }

        // Connect the last odd node to the first even node.
        oddPtr.next = evenHead;

        // Return the head of the new odd-even rearranged linked list
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode newHead = oddEvenList(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
