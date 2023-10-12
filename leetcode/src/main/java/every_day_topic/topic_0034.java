package every_day_topic;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class topic_0034 {
    public static int[] searchRange(int[] nums, int target) {

        int start = -1;
        int end = -1;

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == target) {
                if (start == -1) {
                    start = index;
                }

                end = index;
            }
        }

        return new int[]{start, end};
    }

    public static int[] fastSearchRange(int[] nums, int target) {

        int[] result = new int[] {-1, -1};

        int start = 0;
        int end = nums.length - 1;

        while (start < end){

            if (result[0] == -1) {
                if (nums[start] < target) {
                    start++;
                } else {
                    if (nums[start] > target){
                        return result;
                    } else {
                        result[0] = start;
                    }
                }
            }

            if (result[1] == -1) {
                if (nums[end] > target) {
                    end--;
                } else {
                    if (nums[end] < target){
                        return result;
                    } else {
                        result[1] = end;
                    }
                }
            }

            if (result[0] != -1 && result[1] != -1) {
                return result;
            }
        }

        return result;
    }

}
