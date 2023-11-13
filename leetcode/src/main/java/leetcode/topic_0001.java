package leetcode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_0001 {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {

            int num = nums[index];
            int gap = target - num;

            Integer gapIndex = map.get(gap);
            if (gapIndex != null && gapIndex != index) {
                return new int[]{index, gapIndex};
            } else {
                map.put(num, index);
            }

        }

        return new int[]{-1, -1};

    }

}
