public class Bai0206 {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printAll(n1);
        ListNode reserve = reverseList(n1);
        printAll(reserve);


    }

    public static ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode temp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = temp;
        }
        return prevNode;
    }


    public static void printAll(ListNode head) {
        if (head == null) System.out.println("List is empty");
        ListNode iNode = head;
        while (iNode != null) {
            System.out.print(iNode + " --> ");
            iNode = iNode.next;

        }
        System.out.println();
    }
}
