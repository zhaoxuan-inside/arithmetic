package every_day_topic;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 */
public class topic_0024 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
