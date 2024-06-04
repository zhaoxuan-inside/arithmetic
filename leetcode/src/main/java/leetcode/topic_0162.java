package leetcode;

@SuppressWarnings("unused")
public class topic_0162 {
    public static int findPeakElement(int[] nums) {
        int last = 1;
        int current = 0;
        for (int idx = 0; idx < nums.length - 1; idx++) {
            current = nums[idx] > nums[idx + 1] ? -1 : (nums[idx] < nums[idx + 1] ? 1 : 0);
            if (last > 0 && current < 0) {
                return idx;
            }
            last = current;
        }
        return nums.length - 1;
    }
}
