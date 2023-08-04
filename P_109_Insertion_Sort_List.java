import Classes.ListNode;

public class P_109_Insertion_Sort_List {

    // https://leetcode.com/problems/insertion-sort-list/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, it's already sorted
        }

        ListNode dummy = new ListNode(); // Dummy node to serve as the new head
        ListNode curr = head; // Pointer to traverse the original list

        while (curr != null) {
            ListNode prev = dummy; // Pointer to find the insertion position in the sorted part of the list

            // Traverse the sorted part of the list to find the insertion position
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            ListNode nextCurr = curr.next; // Store the next node to be processed

            // Insert the current node into the sorted part of the list
            curr.next = prev.next;
            prev.next = curr;

            curr = nextCurr; // Move on to the next node in the original list
        }

        return dummy.next; // Return the sorted list starting from the next node of the dummy
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);

        ListNode temp = insertionSortList(head);

        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
