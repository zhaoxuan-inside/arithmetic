package every_day_topic;

import data_structure.ListNode;

@SuppressWarnings("unused")
public class topic_0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }

        ListNode pre = head;
        ListNode last = head;

        int size = 0;
        while (last.next != null){
            if (size == n){

                pre = pre.next;
                last = last.next;

            } else {

                last = last.next;
                size++;

            }
        }

        if (size < n) {
            return pre.next;
        }

        if (pre.next != null) {
            pre.next = pre.next.next;
        }
        return head;
    }

}
