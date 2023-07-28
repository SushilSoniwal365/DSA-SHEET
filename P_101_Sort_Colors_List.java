public class P_101_Sort_Colors_List {

    public static Node segregate(Node head) {
        Node zh = new Node(-1);
        Node zt = zh;
        Node oh = new Node(-1);
        Node ot = oh;
        Node th = new Node(-1);
        Node tt = th;

        Node temp = head;
        while (temp != null) {
            int val = temp.data;

            if (val == 0) {
                zt.next = temp;
                zt = zt.next;
            }

            else if (val == 1) {
                ot.next = temp;
                ot = ot.next;
            }

            else {
                tt.next = temp;
                tt = tt.next;
            }

            temp = temp.next;
        }

        zt.next = oh.next;
        ot.next = th.next;
        tt.next = null;

        if (oh == ot) {
            zt.next = th.next;
        }
        if (zt != zh) {
            head = zh.next;
        } else if (zt == zh && ot != oh) {
            head = oh.next;
        } else if (zt == zh && ot == oh && tt != th) {
            head = th.next;
        }
        return head;
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
