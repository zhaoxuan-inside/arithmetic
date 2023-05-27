package every_day_topic;

import java.util.*;

public class topic_0015 {

    public List<List<Integer>> threeSum(int[] nums) {

        final Set<List<Integer>> result = new HashSet<>();
        final int n = nums.length;

        Arrays.sort(nums);

        for (int axis = 0; axis <= n - 3; axis++) {

            int first = nums[axis];

            int start = axis + 1;
            int end = n - 1;
            while (start < end) {
                if (first + nums[start] + nums[end] == 0) {
                    result.add(Arrays.asList(first, nums[start], nums[end]));
                    start++;
                    end--;
                } else if (first + nums[start] + nums[end] < 0) start++;
                else end--;
            }
        }
        return new ArrayList<>(result);
    }
}