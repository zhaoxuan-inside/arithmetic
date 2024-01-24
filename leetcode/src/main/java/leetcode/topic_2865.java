package leetcode;

import java.util.List;

@SuppressWarnings("unused")
public class topic_2865 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        for (int idx = 0; idx < maxHeights.size(); idx++) {
            long currAns = calHigh(maxHeights, idx);
            ans = Math.max(ans, currAns);
        }
        return ans;
    }

    private long calHigh(List<Integer> maxHeights, int idx) {
        long high = maxHeights.get(idx);
        long ans = 0;
        for (int i = idx + 1; i < maxHeights.size(); i++) {
            if (maxHeights.get(i) <= high) {
                ans += maxHeights.get(i);
                high = maxHeights.get(i);
                continue;
            }
            ans += high;
        }
        high = maxHeights.get(idx);
        for (int i = idx - 1; i >= 0; i--) {
            if (maxHeights.get(i) <= high) {
                ans += maxHeights.get(i);
                high = maxHeights.get(i);
                continue;
            }
            ans += high;
        }
        ans += maxHeights.get(idx);
        return ans;
    }

    static class Faster {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int len = maxHeights.size();
            if (len == 1) return maxHeights.get(0);
            if (len == 2) return maxHeights.get(0) + maxHeights.get(1);

            long[] prefix = new long[len];
            long[] suffix = new long[len];
            int[] stack = new int[len];

            int top = -1;
            for (int idx = 0; idx < len; idx++) {
                int maxHeight = maxHeights.get(idx);
                while (top >= 0 && maxHeight < maxHeights.get(stack[top])) {
                    top--;
                }
                if (top == -1) {
                    prefix[idx] = (long) (idx + 1) * maxHeight;
                } else {
                    prefix[idx] = prefix[stack[top]] + (long) (idx - stack[top]) * maxHeight;
                }
                stack[++top] = idx;
            }

            top = -1;
            long ans = 0;
            for (int idx = len - 1; idx >= 0; idx--) {
                int maxHeight = maxHeights.get(idx);
                while (top >= 0 && maxHeight < maxHeights.get(stack[top])) top--;
                if (top == -1) suffix[idx] = (long) (len - idx) * maxHeight;
                else suffix[idx] = suffix[stack[top]] + (long) (stack[top] - idx) * maxHeight;
                stack[++top] = idx;
                ans = Math.max(ans, prefix[idx] + suffix[idx] - maxHeight);
            }
            return ans;
        }
    }

}
