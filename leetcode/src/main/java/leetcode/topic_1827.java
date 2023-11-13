package leetcode;

@SuppressWarnings("unused")
public class topic_1827 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] <= nums[index - 1]) {
                int gap = nums[index - 1] - nums[index] + 1;
                ans += gap;
                nums[index] += gap;
            }
        }
        return ans;
    }
}
