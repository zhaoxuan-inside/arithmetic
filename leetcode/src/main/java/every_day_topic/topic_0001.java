package every_day_topic;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {

        for (int num : twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(num);
        }

    }

}
