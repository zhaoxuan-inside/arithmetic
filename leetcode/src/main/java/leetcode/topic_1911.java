package leetcode;

@SuppressWarnings("unused")
public class topic_1911 {
    public long maxAlternatingSum(int[] nums) {

        long x = nums[0];
        for (int i = 1; i < nums.length; i++)
            x += Math.max(nums[i] - nums[i - 1], 0);
        return x;

    }
}
