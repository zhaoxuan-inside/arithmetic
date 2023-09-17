package every_day_topic;

public class topic_0213 {
    public int rob(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));

    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int index = start + 2; index <= end; index++) {
            int temp = second;
            second = Math.max(first + nums[index], second);
            first = temp;
        }

        return second;
    }
}
