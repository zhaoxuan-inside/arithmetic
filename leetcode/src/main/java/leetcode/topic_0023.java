package leetcode;

import data_structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0023 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(0);
        List<ListNode> points = new ArrayList<>(Arrays.asList(lists));
        ListNode tail = head;
        int index = 0;

        while (true) {

            ListNode minNode = null;
            int minNodeListSign = 0;

            for (int listIndex = 0; listIndex < lists.length; listIndex++) {

                if (points.get(listIndex) == null) {
                    continue;
                }

                if (minNode == null || points.get(listIndex).val < minNode.val) {
                    minNode = points.get(listIndex);
                    minNodeListSign = listIndex;
                }
            }

            if (minNode == null) {
                return head;
            }

            points.set(minNodeListSign, minNode.next);
            tail.next = minNode;
            minNode.next = null;
            tail = tail.next;
        }
    }

}
