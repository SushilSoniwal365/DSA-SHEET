import Classes.ListNode;

public class P_105_Swap_Nodes {

    // https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode swapNodes(ListNode head, int k) {
        // Step 1: Find the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Find the kth node from the beginning
        ListNode firstNode = head;
        for (int i = 1; i < k; i++) {
            firstNode = firstNode.next;
        }

        // Step 3: Find the kth node from the end (length - k + 1)
        ListNode secondNode = head;
        for (int i = 1; i < length - k + 1; i++) {
            secondNode = secondNode.next;
        }

        // Step 4: Swap the values of the two nodes
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        // Return the updated head of the linked list
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(15);
        head1.next.next.next.next = new ListNode(16);
        head1.next.next.next.next.next = new ListNode(24);

        ListNode current = swapNodes(head1, 3);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
