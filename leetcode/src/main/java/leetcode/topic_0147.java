package leetcode;

public class topic_0147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode ans = new ListNode();

        ListNode orig = new ListNode();
        orig.next = head;

        ListNode last = ans;
        ListNode prev = orig;
        ListNode curr = orig.next;
        int min = Integer.MAX_VALUE;
        ListNode minNodePrev = prev;
        ListNode minNode = curr;
        while (curr != null) {
            while (curr != null) {
                if (curr.val < min) {
                    min = curr.val;
                    minNodePrev = prev;
                    minNode = curr;
                }
                prev = curr;
                curr = curr.next;
            }
            minNodePrev.next = minNode.next;
            min = Integer.MAX_VALUE;
            last.next = minNode;
            last = last.next;
            minNode.next = null;
            prev = orig;
            curr = orig.next;
        }

        return ans.next;
    }
}
