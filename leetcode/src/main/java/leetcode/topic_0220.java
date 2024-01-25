package leetcode;

import java.util.TreeSet;

@SuppressWarnings("unused")
public class topic_0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int idx = 0; idx < len; idx++) {
            Long ceiling = set.ceiling((long) nums[idx] - (long) valueDiff);
            if (ceiling != null && ceiling <= (long) nums[idx] + (long) valueDiff) {
                return true;
            }
            set.add((long) nums[idx]);
            if (idx >= indexDiff) {
                set.remove((long) nums[idx - indexDiff]);
            }
        }
        return false;
    }

}
