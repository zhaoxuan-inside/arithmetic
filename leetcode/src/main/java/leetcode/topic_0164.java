package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_0164 {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int idx = 0; idx < nums.length - 1; idx++) {
            max = Math.max(max, Math.abs(nums[idx + 1] - nums[idx]));
        }
        return max;
    }
}
