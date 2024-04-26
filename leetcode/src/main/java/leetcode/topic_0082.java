package leetcode;

@SuppressWarnings("unused")
public class topic_0082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        ListNode prev = head;
        ListNode end;

        while (start != null) {
            end = start;
            while (end.next != null && end.val == end.next.val) {
                end = end.next;
            }

            if (start == end) {
                prev = start;
                start = start.next;
                continue;
            }

            if (start == head) {
                head = end.next;
                prev = head;
                start = head;
                continue;
            }

            prev.next = end.next;
            start = prev;
        }

        return head;
    }
}
