package leetcode;

@SuppressWarnings("unused")
public class topic_2765 {
    public int alternatingSubarray(int[] nums) {
        int maxLen = 0;
        int len = nums.length;
        int[] mem = new int[len];
        mem[0] = 1;
        for (int end = 1; end < len; end++) {
            if (nums[end] + 1 != nums[end - 1] && nums[end] - 1 != nums[end - 1]) {
                mem[end] = 1;
            } else {
                if (end > 1 && (nums[end - 2] - nums[end - 1]) * -1 == nums[end - 1] - nums[end]) {
                    mem[end] = mem[end - 1] + 1;
                } else if (nums[end] - 1 == nums[end - 1]) {
                    mem[end] = 2;
                } else {
                    mem[end] = 1;
                }
            }
            maxLen = Math.max(maxLen, mem[end]);
        }
        return maxLen < 2 ? -1 : maxLen;
    }

}
