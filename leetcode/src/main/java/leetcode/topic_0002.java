package leetcode;

import data_structure.ListNode;

@SuppressWarnings("unused")
public class topic_0002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode head = new ListNode();
        ListNode last = head;
        int add;

        while (l1 != null || l2 != null) {

            add = 0;

            if (l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }

            add += carry;
            carry = add / 10;

            last.next = new ListNode(add % 10);
            last = last.next;

        }

        if (carry > 0) {
            last.next = new ListNode(carry);
        }

        return head.next;

    }

}
