public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        m1.next = m2;
        m2.next = m3;

        ListNode newNode = mergeTwoLists3(n1, m1);
        printAll(newNode);


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode list3 = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (list3 == null) {
                    list3 = list1;
                    head = list3;
                } else {
                    list3.next = list1;
                    list3 = list3.next;
                }
                list1 = list1.next;
            } else {
                if (list3 == null) {
                    list3 = list2;
                    head = list2;
                } else {
                    list3.next = list2;
                    list3 = list3.next;
                }
                list2 = list2.next;
            }
            printAll(head);

        }
        while (list1 != null) {
            if (list3 == null) {
                list3 = list1;
                head = list3;
            } else {
                list3.next = list1;
                list3 = list3.next;
            }
            list1 = list1.next;
            printAll(head);
        }
        while (list2 != null) {
            if (list3 == null) {
                list3 = list2;
                head = list3;
            } else {
                list3.next = list2;
                list3 = list3.next;
            }
            list2 = list2.next;
            printAll(head);

        }
        return head;

    }


    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }


    public static void printAll(ListNode head) {
        if (head == null) System.out.println("List is empty");
        ListNode iNode = head;
        while (iNode != null) {
            System.out.print(iNode.val + " --> ");
            iNode = iNode.next;
        }
        System.out.println();
    }
}
