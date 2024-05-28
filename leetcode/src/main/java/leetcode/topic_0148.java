package leetcode;

public class topic_0148 {

    public ListNode sortList(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode node;
        ListNode newList = ans;
        while (head != null) {
            node = head;
            head = head.next;
            if (newList.val > node.val) {
                newList = ans;
            }
            while (newList.next != null && newList.next.val < node.val) {
                newList = newList.next;
            }
            node.next = newList.next;
            newList.next = node;
        }
        return ans.next;
    }

    public ListNode better(ListNode head) {
        ListNode tmp = head;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (tmp != null) {
            max = max > tmp.val ? max : tmp.val;
            min = min < tmp.val ? min : tmp.val;
            tmp = tmp.next;
        }

        int len = max - min + 1;
        int[] buckets = new int[len];
        for (tmp = head; tmp != null; tmp = tmp.next) {
            buckets[tmp.val - min]++;
        }

        tmp = head;
        for (int i = 0; i < len; i++) {
            while (buckets[i] != 0) {
                tmp.val = i + min;
                buckets[i]--;
                tmp = tmp.next;
            }
        }
        return head;
    }
}
