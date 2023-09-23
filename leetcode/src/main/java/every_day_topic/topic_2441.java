package every_day_topic;

import sun.nio.cs.ext.MacHebrew;

import java.util.*;

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
