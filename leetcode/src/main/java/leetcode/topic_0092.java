package leetcode;

public class topic_0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ans = new ListNode(0);

        ListNode idx = head;
        ListNode last = ans;
        boolean reverse = false;
        int counter = 1;
        while (idx != null) {
            if (counter == left) {
                reverse = !reverse;
            }
            ListNode temp = idx;
            idx = idx.next;
            temp.next = null;
            if (!reverse) {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = temp;
                last = last.next;
            } else {
                temp.next = last.next;
                last.next = temp;
            }
            if (counter == right) {
                reverse = !reverse;
            }
            counter++;
        }
        return ans.next;
    }
}
