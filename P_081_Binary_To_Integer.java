import Classes.ListNode;

public class P_081_Binary_To_Integer {

    // https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

    // ? T.C = O(n) & S.C = O(1).
    public static int getDecimalValue(ListNode head) {
        int num = head.val;
        head = head.next;
        while (head != null) {
            num = num * 2 + head.val;
            head = head.next;
        }
        return num;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 0 -> 1
        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(getDecimalValue(node1));
    }
}
