package leetcode;

public class topic_0141 {
    public boolean hasCycle(ListNode head) {
        ListNode faster = head, slower = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) {
                return true;
            }
        }
        return false;
    }
}
