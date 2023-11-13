package leetcode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_2441 {
    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(-num)) {
                max = Math.max(max, Math.abs(num));
            } else {
                set.add(num);
            }
        }
        return max;
    }
}
