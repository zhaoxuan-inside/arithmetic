package leetcode;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0260 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int[] ans = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            ans[index++] = num;
        }
        return ans;
    }
}
