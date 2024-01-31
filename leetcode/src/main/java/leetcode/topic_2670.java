package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_2670 {
    public static int[] distinctDifferenceArray(int[] nums) {
        int[] ans = new int[nums.length];

        Map<Integer, Integer> last = new HashMap<>();
        for (int num : nums) {
            Integer count = last.get(num);
            if (count == null) {
                count = 0;
            }
            count++;
            last.put(num, count);
        }

        Set<Integer> pre = new HashSet<>();
        for (int idx = 0; idx < nums.length; idx++) {
            pre.add(nums[idx]);

            Integer lastCount = last.get(nums[idx]);
            lastCount--;
            if (lastCount == 0) {
                last.remove(nums[idx]);
            } else {
                last.put(nums[idx], lastCount);
            }
            ans[idx] = pre.size() - last.keySet().size();
        }

        return ans;
    }

    static class Faster {
        public static int[] distinctDifferenceArray(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];

            long preMask = 0L;
            long lastMask = 0L;
            int[] pre = new int[len];
            int[] last = new int[len];
            for (int i = 0; i < len; i++) {
                preMask |= 1L << nums[i];
                pre[i] = Long.bitCount(preMask);

                lastMask |= 1L << nums[len - i - 1];
                last[len - i - 1] = Long.bitCount(lastMask);
            }

            for (int idx = 0; idx < len - 1; idx++) {
                ans[idx] = pre[idx] - last[idx + 1];
            }

            ans[len - 1] = pre[len - 1];

            return ans;
        }

        public static void main(String[] args) {
            distinctDifferenceArray(new int[]{1, 2, 3, 4, 5});
        }
    }
}
