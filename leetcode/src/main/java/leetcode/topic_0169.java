package leetcode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_0169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mem = new HashMap<>();
        int half = nums.length / 2;

        for (int num : nums) {
            Integer count = mem.get(num);
            if (count == null) {
                count = 0;
            }
            count++;
            if (count > half) {
                return num;
            }
            mem.put(num, count);
        }

        return -1;
    }

    private int count = 0;
    public int faster(int[] nums) {
        return execute(nums, 0);
    }

    public int execute(int[] nums, int start) {
        for (int index = start; index < nums.length; index++) {
            if (nums[index] == nums[start]) {
                count++;
            } else if (--count < 1) {
                return execute(nums, index + 1);
            }
        }
        return nums[start];
    }
}
