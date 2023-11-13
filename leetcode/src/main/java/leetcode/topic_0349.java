package leetcode;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i : nums2) {
            if (set.contains(i)) {
                set.remove(i);
                result[index] = i;
                index++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
