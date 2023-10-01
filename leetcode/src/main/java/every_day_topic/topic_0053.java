package every_day_topic;

@SuppressWarnings("unused")
public class topic_0053 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;

        int[] mem = new int[length];
        mem[0] = nums[0];

        int ans = mem[0];
        for (int index = 1; index < length; index++) {
            if (mem[index - 1] > 0) {
                mem[index] = mem[index - 1] + nums[index];
            } else {
                mem[index] = nums[index];
            }
            ans = Math.max(ans, mem[index]);
        }

        return ans;
    }
}
