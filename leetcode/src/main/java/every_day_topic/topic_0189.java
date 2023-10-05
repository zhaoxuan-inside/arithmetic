package every_day_topic;

@SuppressWarnings("unused")
public class topic_0189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int index = 0; index < length; index++) {
            ans[(index + k) % length] = nums[index];
        }
        System.arraycopy(ans, 0, nums, 0, length);
    }

    public void faster(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start++ < end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
}
