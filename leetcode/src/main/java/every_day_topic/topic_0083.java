package every_day_topic;

@SuppressWarnings("unused")
public class topic_0083 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode pre = curr.next;
            if (curr.val == pre.val) {
                curr.next = pre.next;
            } else {
                curr = pre;
            }
        }
        return head;
    }

}
