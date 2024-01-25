package leetcode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_0219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> WINDOWS = new HashMap<>();
        for (int idx = 0; idx < k && idx < nums.length; idx++) {
            Integer count = WINDOWS.get(nums[idx]);
            if (count == null) {
                count = 1;
            } else {
                return true;
            }
            WINDOWS.put(nums[idx], count);
        }

        for (int idx = k; idx < nums.length; idx++) {
            Integer integer = WINDOWS.get(nums[idx]);
            if (integer != null) {
                return true;
            }
            WINDOWS.put(nums[idx], 1);
            WINDOWS.remove(nums[idx - k]);
        }
        return false;
    }
}
