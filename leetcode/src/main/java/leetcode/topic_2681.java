package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_2681 {
    public static int sumOfPower(int[] nums) {

        Arrays.sort(nums);

        double result = 0;
        double max = Math.pow(10, 9) + 7;

        long[] timesCache = new long[nums.length];

        for (int end = 0; end < nums.length; end++) {

            int times = 0;

            for (int start = end - 1; start >= 0; start--) {

                long prefix;
                if (times - 1 < 0) {
                    prefix = (long) Math.pow(2, times++);
                    prefix = (long) (prefix % max);
                    timesCache[times] = prefix;
                } else {
                    if (timesCache[times] == 0) {
                        prefix = timesCache[times - 1] * 2;
                        prefix = (long) (prefix % max);
                        timesCache[times] = prefix;
                    } else {
                        prefix = timesCache[times];
                    }
                }

                double tmp = (((prefix * nums[start]) % max * nums[end]) % max * nums[end]) % max;
                result = (result + tmp) % max;
            }

            double tmp = ((nums[end] * nums[end]) % max * nums[end]) % max;
            result = (result + tmp) % max;
        }

        return (int) result;

    }

}
