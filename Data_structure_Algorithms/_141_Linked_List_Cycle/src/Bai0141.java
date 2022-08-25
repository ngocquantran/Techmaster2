public class Bai0141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode m1 = head;
        ListNode m2 = head;
        while (m1 != null) {
            if (m2 == null || m2.next == null) return false;
            m2 = m2.next.next;
            if (m1 == m2) return true;
            m1 = m1.next;
        }
        return false;
    }
}
