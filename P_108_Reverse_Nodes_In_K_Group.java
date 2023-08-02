import Classes.ListNode;

public class P_108_Reverse_Nodes_In_K_Group {

    // https://leetcode.com/problems/reverse-nodes-in-k-group/description/

    // ? T.C = O(n), S.C = O(n/k)
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Calculate the length of the linked list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Base case: If the remaining nodes are less than k, return head
        if (length < k) {
            return head;
        }

        // Base case: If the linked list is empty, return null
        if (head == null) {
            return null;
        }

        // Step 2: Reverse the first k nodes in the current group
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node
            prev = curr; // Move prev to the current node
            curr = next; // Move curr to the next node
            count++;
        }

        // Step 3: Recursively reverse the next group and connect it to the current
        // group's end
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Step 4: Return the new head of the reversed group
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);

        ListNode temp = reverseKGroup(head, 3);

        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
