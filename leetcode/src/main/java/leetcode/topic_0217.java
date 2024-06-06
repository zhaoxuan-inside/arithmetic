package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_0217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int idx = 0; idx < nums.length - 1; idx++) {
            if (nums[idx] == nums[idx + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean better(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int gap = max - min + 1;
        if (gap > nums.length * 10) {
            Arrays.sort(nums);
            for (int idx = 0; idx < nums.length - 1; idx++) {
                if (nums[idx] == nums[idx + 1]) {
                    return true;
                }
            }
            return false;
        }

        boolean[] sign = new boolean[gap];

        for (int num : nums) {
            int idx = num - min;
            if (sign[idx]) {
                return true;
            }
            sign[idx] = true;
        }
        return false;
    }
}
