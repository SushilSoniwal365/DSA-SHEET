import Classes.Node;

public class P_103_Add_One_To_The_LinkedList {

    // https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

    // ? T.C = O(n) & S.C = O(1).
    public static Node addOneToList(Node head) {
        // Step 1: Reverse the linked list to make the addition process easier.
        head = reverseLinkedList(head);

        Node temp = head;
        boolean carry = true; // Indicates if there's a carry after adding one to the current digit.

        while (temp != null && carry) {
            if (temp.next == null && temp.data == 9) {
                // If last digit is 9, set it to 0, and add a new node with a value of 1.
                temp.data = 0;
                Node newNode = new Node(1);
                temp.next = newNode;
                break;
            } else if (temp.data == 9) {
                // If the current digit is 9, set it to 0 and move to the next node.
                temp.data = 0;
                temp = temp.next;
            } else {
                // If the current digit is not 9, simply add 1 to it, and stop the iteration.
                temp.data += 1;
                carry = false;
            }
        }

        // Step 2: Reverse the linked list back to its original order.
        head = reverseLinkedList(head);
        return head;
    }

    // Helper function to reverse a linked list.
    public static Node reverseLinkedList(Node head) {
        Node currNode = head;
        Node prevNode = null;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node res = addOneToList(head1);
        Node current = res;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
