class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class P_84_Length_Of_Linked_List {

    // https://bit.ly/3HldJtX

    // ? T.C = O(n) & S.C = O(1).
    public static int isLengthEvenorOdd(Node head1) {
        int c = 0;
        Node temp = head1;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        if (c % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int num = isLengthEvenorOdd(head);
        if (num == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}
