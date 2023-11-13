package leetcode;

@SuppressWarnings("unused")
public class topic_0035 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        return nums[mid] > target ? mid : mid + 1;

    }
}
