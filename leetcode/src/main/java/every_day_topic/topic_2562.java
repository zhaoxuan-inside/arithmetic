package every_day_topic;

@SuppressWarnings("unused")
public class topic_2562 {
    public long findTheArrayConcVal(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        long result = 0;

        while (start < end) {
            result += Long.parseLong(nums[start] + String.valueOf(nums[end]));
            start++;
            end--;
        }

        return result += ((start == end) ? nums[start] : 0);
    }
}
