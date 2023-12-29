package leetcode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_0961 {
    public static int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }
}
