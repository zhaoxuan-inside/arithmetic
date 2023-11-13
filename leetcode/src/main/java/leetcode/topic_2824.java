package leetcode;

import java.util.List;

@SuppressWarnings("unused")
public class topic_2824 {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;

        for (int pre = 0; pre < nums.size(); pre++) {
            for (int last = pre + 1; last < nums.size(); last++) {
                if (nums.get(pre) + nums.get(last) < target) {
                    count++;
                }
            }
        }

        return count;
    }
}
