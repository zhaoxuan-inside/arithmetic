package leetcode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null || headB != null) {
            if (headA != null) {
                set.add(headA);
                headA = headA.next;
                if (set.contains(headA)) {
                    return headA;
                }
            }

            if (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                set.add(headB);
                headB = headB.next;
            }

        }
        return null;
    }

    public ListNode better(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        int counterA = 0;
        int counterB = 0;
        while (pointerA != null || pointerB != null) {
            if (pointerA != null) {
                counterA++;
                pointerA = pointerA.next;
            }
            if (pointerB != null) {
                counterB++;
                pointerB = pointerB.next;
            }
        }

        pointerA = headA;
        pointerB = headB;
        while (counterA > counterB) {
            pointerA = pointerA.next;
            counterA--;
        }
        while (counterB > counterA) {
            pointerB = pointerB.next;
            counterB--;
        }

        while (pointerA != null && pointerB != null) {
            if (pointerA == pointerB) {
                break;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA;
    }
}
