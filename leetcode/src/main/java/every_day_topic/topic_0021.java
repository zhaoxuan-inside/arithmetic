package every_day_topic;

public class topic_0021 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();

        ListNode idx1 = list1;
        ListNode idx2 = list2;
        ListNode index = head;

        while (idx1 != null && idx2 != null){
            if (idx1.val < idx2.val){
                index.next = idx1;
                idx1 = idx1.next;
            } else {
                index.next = idx2;
                idx2 = idx2.next;
            }

            index = index.next;
        }

        if (idx1 != null ){
            index.next = idx1;
        }

        if (idx2 != null){
            index.next = idx2;
        }

        return head.next;

    }
}


