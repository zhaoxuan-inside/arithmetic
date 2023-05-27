package every_day_topic;

import data_structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("unused")
public class topic_0025 {

    public ListNode reverseKGroup(ListNode head, int k) {

        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while (true) {

            int count = 0;
            ListNode tmp = head;

            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }

            if (count != k) {
                result.next = head;
                break;
            }

            while (!stack.isEmpty()) {
                result.next = stack.pollLast();
                result = result.next;
            }

            result.next = tmp;
            head = tmp;

        }

        return dummy.next;

    }

}
