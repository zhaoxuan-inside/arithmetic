package leetcode;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0228 {
    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        int low = 0;
        int height = 0;

        while (height < nums.length) {

            if (height + 1 < nums.length && nums[height] + 1 == nums[height + 1]) {
                height++;
                continue;
            }

            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low == height) {
                result.add(String.valueOf(temp));
                low++;
                height++;
                continue;
            }

            result.add(String.valueOf(temp.append("->").append(nums[height])));
            low = height + 1;
            height++;

        }
        return result;
    }

}
