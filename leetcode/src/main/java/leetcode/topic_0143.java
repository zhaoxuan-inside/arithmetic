package leetcode;

public class topic_0143 {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = findMid(head);
        ListNode reverseHead = reverse(mid.next);
        mid.next = null;

        mid = head;
        while (mid != null && reverseHead != null) {
            ListNode next = reverseHead.next;
            reverseHead.next = mid.next;
            mid.next = reverseHead;
            reverseHead = next;
            mid = mid.next.next;
        }
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode last = head;
        ListNode mid = head.next;
        if (mid == null) {
            return last;
        }
        ListNode prev = mid.next;

        while (prev != null) {
            mid.next = last;
            last = mid;
            mid = prev;
            prev = prev.next;
        }
        mid.next = last;
        head.next = null;
        return mid;
    }

}
