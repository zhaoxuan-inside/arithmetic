package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_2815 {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int result = -1;

        for (int index = nums.length - 1; index >= 0; index--) {
            char[] chars = String.valueOf(nums[index]).toCharArray();
            Arrays.sort(chars);
            char max = chars[chars.length - 1];

            for (int pre = index - 1; pre >= 0; pre--) {
                int add = nums[index] + nums[pre];

                if (add < result) {
                    break;
                }

                char[] preChars = String.valueOf(nums[pre]).toCharArray();
                Arrays.sort(preChars);
                char maxPre = preChars[preChars.length - 1];
                if (max == maxPre) {
                    result = add;
                    break;
                }
            }
        }

        return result;

    }

    public int batter(int[] nums) {
        int ans = -1;

        int[] maxVal = new int[10];

        Arrays.fill(maxVal, Integer.MIN_VALUE);

        for (int num : nums) {
            int maxD = 0;
            for (int x = num; x > 0; x = x / 10) {
                maxD = Math.max(maxD, x % 10);
            }
            ans = Math.max(ans, num + maxVal[maxD]);
            maxVal[maxD] = Math.max(maxVal[maxD], num);
        }
        return ans;
    }
}
