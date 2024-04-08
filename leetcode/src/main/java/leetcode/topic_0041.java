package leetcode;

@SuppressWarnings("unused")
public class topic_0041 {
    public static int firstMissingPositive(int[] nums) {
        int min = 1;
        int count = 0;
        while (min == 1) {
            min = Integer.MAX_VALUE;
            for (int idx = 0; idx < nums.length; idx++) {
                if (nums[idx] > 0) {
                    min = Math.min(nums[idx], min);
                    nums[idx]--;
                }
            }
            count++;
        }
        return count;
    }

    public int better(int[] nums) {
        int len = nums.length;

        for (int idx = 0; idx < len; idx++) {
            while (nums[idx] > 0 && nums[idx] <= len && nums[nums[idx] - 1] != nums[idx]) {
                swap(nums, nums[idx] - 1, idx);
            }
        }

        for (int idx = 0; idx < len; idx++) {
            if (nums[idx] != idx + 1) {
                return idx + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
