package leetcode;

import java.util.HashSet;
import java.util.Set;

public class topic_0142 {
    public ListNode detectCycle(ListNode head) {
        ListNode ans = null;
        Set<ListNode> set = new HashSet<>();
        ListNode idx = head;
        while (idx != null) {
            if (set.contains(idx)) {
                ans = idx;
                break;
            } else {
                set.add(idx);
            }
            idx = idx.next;
        }
        return ans;
    }

    public ListNode better(ListNode head) {
        ListNode faster, slower;
        faster = head;
        slower = head;

        while (true) {
            if (faster == null || faster.next == null) {
                return null;
            }
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) {
                break;
            }
        }

        faster = head;
        while (faster != slower) {
            faster = faster.next;
            slower = slower.next;
        }
        return faster;
    }
}
