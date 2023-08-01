import Classes.ListNode;

public class P_107_Partition_List {

    // leetcode.com/problems/partition-list/description/

    // ? T.C = O(n) & S.C = O(1).
    public static ListNode partition(ListNode head, int x) {
        // Create two dummy nodes for the two partitions: less and greater
        ListNode lessDummy = new ListNode(0);
        ListNode less = lessDummy;
        ListNode greaterDummy = new ListNode(0);
        ListNode greater = greaterDummy;

        // Traverse the original linked list and move nodes to the appropriate partition
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Connect the two partitions.
        greater.next = null;
        less.next = greaterDummy.next;

        // Return the head of the less partition (skipping the dummy node)
        return lessDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);

        ListNode temp = partition(head, 3);

        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
