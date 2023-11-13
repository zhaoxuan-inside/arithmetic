package leetcode;

import data_structure.ListNode;

/**
 * 给你一个链表的头 head ，每个结点包含一个整数值。
 * <p>
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 * <p>
 * 请你返回插入之后的链表。
 * <p>
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 */

@SuppressWarnings("unused")
public class topic_2807 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode index = head;

        while (index != null) {
            if (index.next != null) {
                ListNode node = new ListNode(commonDivisor(index.val, index.next.val));
                node.next = index.next;
                index.next = node;
                index = index.next;
            }
            index = index.next;
        }

        return head;
    }

    private int commonDivisor(int num1, int num2) {
        int bigger = Math.max(num1, num2);
        int litter = Math.min(num1, num2);

        while (bigger % litter != 0) {
            int tmp = bigger % litter;
            bigger = litter;
            litter = tmp;
        }

        return litter;

    }

}
