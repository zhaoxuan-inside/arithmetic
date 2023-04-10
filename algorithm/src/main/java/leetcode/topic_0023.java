package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
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

                if (points.get(listIndex) == null){
                    continue;
                }

                if (minNode == null || points.get(listIndex).val < minNode.val){
                    minNode = points.get(listIndex);
                    minNodeListSign = listIndex;
                }
            }

            if (minNode == null){
                return head;
            }

            points.set(minNodeListSign, minNode.next);
            tail.next = minNode;
            minNode.next = null;
            tail = tail.next;
        }
    }


    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            return mergeKListsCode(lists,0,lists.length - 1);
        }

        private ListNode mergeKListsCode(ListNode[] lists,int start, int end){

            if(start > end){
                return null;
            }

            if(start == end){
                return lists[start];
            }

            int mid = (start + end) >> 1;  // 除2

            ListNode left = mergeKListsCode(lists, start, mid);
            ListNode right = mergeKListsCode(lists,mid + 1,end);

            return merge(left,right);

        }

        private ListNode merge(ListNode left, ListNode right) {

            ListNode head = new ListNode();
            ListNode temp = head;

            while (left != null && right != null){
                if(left.val < right.val){
                    temp.next = new ListNode(left.val);
                    left = left.next;
                    temp = temp.next;
                }else {
                    temp.next = new ListNode(right.val);
                    right = right.next;
                    temp = temp.next;
                }
            }

            while (left != null){
                temp.next = new ListNode(left.val);
                temp = temp.next;
                left = left.next;
            }
            while (right != null){
                temp.next = new ListNode(right.val);
                temp = temp.next;
                right = right.next;
            }
            return head.next;
        }
    }
}
