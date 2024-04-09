package leetcode;

@SuppressWarnings("unused")
public class topic_0045 {
    public static int jump(int[] nums) {
        return jump(nums, 0);
    }

    public static int jump(int[] nums, int curr) {
        if (curr >= nums.length - 1) {
            return 0;
        }
        int nextIdx = curr;
        int nextStep = nums[nextIdx] + nextIdx;
        if (nextStep >= nums.length - 1) {
            return 1;
        }

        for (int idx = curr; idx < nums.length && idx <= nums[curr] + curr; idx++) {
            int currNextStep = nums[idx] + idx;
            if (currNextStep > nextStep) {
                nextStep = currNextStep;
                nextIdx = idx;
            }
        }
        return jump(nums, nextIdx) + 1;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{3, 4, 3, 2, 5, 4, 3}));
    }
}
