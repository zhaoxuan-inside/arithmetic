package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class compete_100110 {
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        for (int idx = 0; idx < queries.length; idx++) {
            int a = queries[idx][0];
            int b = queries[idx][1];
            int minIdx = Math.max(a, b);
            if (a == b) {
                ans[idx] = a;
                continue;
            }
            if (a == minIdx ? heights[b] < heights[minIdx] : heights[a] < heights[minIdx]) {
                ans[idx] = minIdx;
                continue;
            }
            for (int commIdx = minIdx + 1; commIdx < heights.length; commIdx++) {
                if (heights[a] < heights[commIdx] && heights[b] < heights[commIdx]) {
                    ans[idx] = commIdx;
                    break;
                }
            }
        }
        return ans;
    }

}
