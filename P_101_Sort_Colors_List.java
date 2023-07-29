public class P_101_Sort_Colors_List {

    // https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

    // ? T.C = O(n) & S.C = O(1).
    public static Node segregate(Node head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one element, it is already sorted
            return head;
        }

        // Initialize three dummy nodes to create three partitions
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);
        Node zeroTail = zeroDummy;
        Node oneTail = oneDummy;
        Node twoTail = twoDummy;

        // Traverse the original list and place nodes into respective partitions
        Node current = head;
        while (current != null) {
            if (current.data == 0) {
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            } else if (current.data == 1) {
                oneTail.next = current;
                oneTail = oneTail.next;
            } else {
                twoTail.next = current;
                twoTail = twoTail.next;
            }
            current = current.next;
        }

        // Connect the three partitions together
        zeroTail.next = oneDummy.next != null ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        // The head of the sorted list is the next node of the zeroDummy node
        return zeroDummy.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = new Node(2);
        head1.next.next.next.next.next = new Node(0);

        Node current = segregate(head1);
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
