package leetcode;

public class topic_0109 {
    public static TreeNode sortedListToBST(ListNode head) {
        TreeNode treeNode = buildTree(head);
        return treeNode;
    }

    private static TreeNode buildTree(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode tmpRoot = findMid(head);
        TreeNode root = new TreeNode(tmpRoot.val);
        ListNode right = tmpRoot.next;
        root.left = buildTree(head);
        root.right = buildTree(right);
        return root;
    }

    private static ListNode findMid(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

}
