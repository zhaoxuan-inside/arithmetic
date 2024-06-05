package leetcode;

@SuppressWarnings("unused")
public class topic_0153 {
    public static int findMin(int[] nums) {

        int len = nums.length;

        int pre = 0;
        int last = len - 1;
        int mid;
        while (pre < last) {
            if (nums[pre] < nums[last]) {
                return nums[pre];
            }

            if (pre + 1 == last) {
                return Math.min(nums[pre], nums[last]);
            }

            mid = (pre + last) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[pre]) {
                pre = mid + 1;
                continue;
            }

            if (nums[mid] < nums[last]) {
                last = mid;
            }

        }

        return nums[pre];
    }

}
