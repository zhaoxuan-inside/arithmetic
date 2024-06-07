package leetcode;

@SuppressWarnings("unused")
public class topic_0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (fast.next != null) {
            fast = fast.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode idx = temp;
        while (idx != fast) {
            idx = idx.next;
            temp = fast.next;
            fast = temp;
            temp = idx;
        }

        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
