package every_day_topic;

import data_structure.ListNode;

@SuppressWarnings("unused")
public class topic_0024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode headNode = new ListNode(0);
        ListNode tail = headNode;

        ListNode pre = head;
        ListNode last = head.next;

        while (last != null){
            ListNode tmp;
            tail.next = last;
            tmp = last.next;
            last.next = pre;
            tail = pre;
            pre.next = null;

            if (tmp != null) {
                last = tmp.next;
                pre = tmp;
            } else {
                pre = null;
                last = null;
            }
        }

        tail.next = pre;

        return headNode.next;
    }
}
