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


    List<List<Integer>> result = null;

    public List<List<Integer>> batterThreeSum(int[] nums) {

        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int index) {
                init();
                return result.get(index);
            }

            public int size() {
                init();
                return result.size();
            }

            private void init() {
                if (result != null) return;

                final int n = nums.length;
                final Set<List<Integer>> set = new HashSet<List<Integer>>();
                Arrays.sort(nums);//进行排序
                for (int start = 0; start <= n - 3; start++) {
                    int firstNum = nums[start];
                    int mid = start + 1;
                    int end = n - 1;
                    while (mid < end) {
                        if (firstNum + nums[mid] + nums[end] == 0) {
                            set.add(Arrays.asList(firstNum, nums[mid], nums[end]));
                            mid++;
                            end--;
                        } else if (firstNum + nums[mid] + nums[end] < 0) mid++;
                        else end--;
                    }
                }

                result = new ArrayList<List<Integer>>(set);

            }
        };
    }

}