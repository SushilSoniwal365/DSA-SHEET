public class P_96_Segregate_Even_And_Odd_Nodes_In_LinkedList {

    // https://shorturl.at/eiSX2

    // ? T.C = O(n) & S.C = O(1).
    public static Node divide(int N, Node head) {
        // Check for empty list or a list with only one node
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = new Node(0);
        Node oddTail = odd;

        Node even = new Node(0);
        Node evenTail = even;

        Node temp = head;
        while (temp != null) {
            if (temp.data % 2 == 0) {
                evenTail.next = temp;
                evenTail = evenTail.next;
            } else {
                oddTail.next = temp;
                oddTail = oddTail.next;
            }
            temp = temp.next;
        }

        evenTail.next = odd.next;
        oddTail.next = null;

        return even.next;
    }

    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);

        Node newHead = divide(7, head);
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}
