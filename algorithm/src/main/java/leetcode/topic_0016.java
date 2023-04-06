package leetcode;


import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 */
public class topic_0016 {
    public int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE;
        int sum = 0;
        int result = 0;

        Arrays.sort(nums);

        int pre;
        int last = nums.length - 1;
        int num1;
        int num2;
        int num3;
        int currGap;

        for (int i = 0; i < nums.length - 2; i++) {
            pre = i + 1;
            last = nums.length - 1;

            while (pre < last) {
                num1 = nums[i];
                num2 = nums[pre];
                num3 = nums[last];
                sum = num1 + num2 + num3;
                currGap = sum  - target;

                if (Math.abs(currGap) < gap) {
                    gap = Math.abs(currGap);
                    result = sum;

                    if (gap == 0){
                        return target;
                    }
                }

                if (currGap > 0) {
                    last--;
                } else {
                    pre++;
                }
            }
        }

        return result;

    }
}
