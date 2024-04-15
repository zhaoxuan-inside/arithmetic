package leetcode;

@SuppressWarnings("unused")
public class topic_0075 {
    public static void sortColors(int[] nums) {
        int len = nums.length;
        int lastZero = 0;
        for (int idx = 0; idx < len; idx++) {
            if (nums[idx] == 0) {
                swap(nums, lastZero, idx);
                lastZero++;
            }
        }
        int lastTwo = len - 1;
        for (int idx = len - 1; idx >= lastZero; idx--) {
            if (nums[idx] == 2) {
                swap(nums, lastTwo, idx);
                lastTwo--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
