package leetcode;

@SuppressWarnings("unused")
public class topic_0061 {
    public static ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (true) {
            if (node == null) {
                break;
            }
            len++;
            if (node.next == null) {
                node.next = head;
                break;
            }
            node = node.next;
        }

        if (len == 0) {
            return head;
        }
        if (len == 1) {
            head.next = null;
            return head;
        }

        int step = len - (k % len);
        ListNode tail = head;
        int idx = 0;
        while (idx++ < step) {
            tail = head;
            head = head.next;
        }

        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        int idx = 2;
        while (idx <= 5) {
            node.next = new ListNode(idx++);
            node = node.next;
        }

        head = rotateRight(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
