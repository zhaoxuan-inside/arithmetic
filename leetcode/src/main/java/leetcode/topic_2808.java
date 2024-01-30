package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_2808 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.size();
        int ans = len;
        for (int idx = 0; idx < len; ++idx) {
            map.computeIfAbsent(nums.get(idx), k -> new ArrayList<>()).add(idx);
        }
        for (List<Integer> positions : map.values()) {
            int gap = positions.get(0) + len - positions.get(positions.size() - 1);
            for (int idx = 1; idx < positions.size(); ++idx) {
                gap = Math.max(gap, positions.get(idx) - positions.get(idx - 1));
            }
            ans = Math.min(ans, gap / 2);
        }
        return ans;
    }
}

class Faster {
    public int minimumSeconds(List<Integer> nums) {
        int len = nums.size();
        Map<Integer, int[]> map = new HashMap<>();
        int min = len - 1;
        for (int idx = 0; idx < len; ++idx) {
            int num = nums.get(idx);
            int[] preNumIdxs = map.get(num);
            if (preNumIdxs != null) {
                int ascGap = idx - preNumIdxs[0] - 1;
                int descGap = len - 1 + preNumIdxs[1] - idx;
                preNumIdxs[0] = idx;
                preNumIdxs[2] = Math.max(preNumIdxs[2], ascGap);
                int change = Math.max(preNumIdxs[2], descGap);
                min = Math.min(change, min);
            } else {
                map.put(num, new int[]{idx, idx, -1});
            }
        }
        return (min + 1) / 2;
    }
}
