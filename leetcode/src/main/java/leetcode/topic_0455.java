package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_0455 {
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int childIdx = 0;
        int cookIdx = 0;
        while (childIdx < children.length && cookIdx < cookies.length) {
            if (children[childIdx] <= cookies[cookIdx]) {
                childIdx++;
            }
            cookIdx++;
        }
        return childIdx;
    }
}
