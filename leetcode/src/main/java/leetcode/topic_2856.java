package leetcode;

import java.util.List;

@SuppressWarnings("unused")
public class topic_2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int preStart = 0;
        int lastStart;

        int length = nums.size();

        if (nums.size() % 2 == 0) {
            lastStart = nums.size() / 2;
        } else {
            lastStart = nums.size() / 2 + 1;
        }

        while (lastStart < nums.size()) {
            if (!nums.get(preStart).equals(nums.get(lastStart))) {
                length -= 2;
            }
            lastStart++;
            preStart++;
        }

        return length;
    }
}
