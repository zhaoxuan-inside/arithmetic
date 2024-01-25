package leetcode;

import java.util.List;

@SuppressWarnings("unused")
public class topic_2859 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int idx = 0; idx < nums.size(); idx++) {
            if (Integer.bitCount(idx) == k) {
                ans += nums.get(idx);
            }
        }
        return ans;
    }

}
