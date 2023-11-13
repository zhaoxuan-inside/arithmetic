package leetcode;

import data_structure.ListNode;

@SuppressWarnings("unused")
public class topic_0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list1 = reverseListNode(l1);
        ListNode list2 = reverseListNode(l2);

        ListNode result = new ListNode();
        ListNode last = null;

        int carry = 0;

        while (list1 != null || list2 != null) {

            int num1 = 0;
            int num2 = 0;
            if (list1 != null) {
                num1 = list1.val;
            }
            if (list2 != null) {
                num2 = list2.val;
            }

            int sum = num1 + num2 + carry;
            carry = sum / 10;

            ListNode currNode = new ListNode(sum % 10);
            currNode.next = last;
            last = currNode;
            result = currNode;

            if (list1 != null) {
                list1 = list1.next;
            }

            if (list2 != null) {
                list2 = list2.next;
            }
        }

        if (carry != 0) {
            ListNode listNode = new ListNode(carry);
            listNode.next = result;
            result = listNode;
        }
        return result;

    }

    private ListNode reverseListNode(ListNode list) {
        ListNode per = null;
        ListNode curr = list;
        ListNode next = curr.next;

        while (curr.next != null) {
            curr.next = per;
            per = curr;
            curr = next;
            next = next.next;
        }

        curr.next = per;

        return curr;
    }

}
