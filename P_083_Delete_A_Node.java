import Classes.ListNode;

public class P_083_Delete_A_Node {

    // https://leetcode.com/problems/delete-node-in-a-linked-list

    // ? T.C = O(1) & S.C = O(1).
    public static void deleteNode(ListNode node) {

        // Copy the data from the next node to the current node
        node.val = node.next.val;

        // Bypass the next node
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Delete 3 from linked list.
        deleteNode(head.next.next);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
