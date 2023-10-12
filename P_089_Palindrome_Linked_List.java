import Classes.ListNode;

public class P_089_Palindrome_Linked_List {

    // https://leetcode.com/problems/palindrome-linked-list/

    // ? T.C = O(n) & S.C = O(1).
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverseLinkedList(slow);

        // Step 3: Compare the first half with the reversed second half
        ListNode current1 = head;
        ListNode current2 = reversedSecondHalf;
        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return true;
    }

    // * Method To Reverse The Second Half Of Linked List.
    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
