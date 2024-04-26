package leetcode;

public class topic_0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode bigger = new ListNode();
        ListNode smaller = new ListNode();
        ListNode biggerPoint = bigger;
        ListNode smallerPoint = smaller;


        while (head != null) {
            if (head.val < x) {
                smallerPoint.next = head;
                head = head.next;
                smallerPoint = smallerPoint.next;
                smallerPoint.next = null;
            } else {
                biggerPoint.next = head;
                head = head.next;
                biggerPoint = biggerPoint.next;
                biggerPoint.next = null;
            }
        }

        if (smaller.next != null) {
            smallerPoint.next = bigger.next;
            return smaller.next;
        }
        return bigger.next;
    }
}
