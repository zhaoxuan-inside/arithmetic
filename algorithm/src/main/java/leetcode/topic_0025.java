package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 */
public class topic_0025 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
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
