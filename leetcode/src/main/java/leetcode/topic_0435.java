package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_0435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;

        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] == interval2[0]) {
                return interval2[1] - interval1[1];
            }
            return interval1[0] - interval2[0];
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int idx = 1; idx < intervals.length; idx++) {
            if (Math.max(start, intervals[idx][0]) < Math.min(end, intervals[idx][1])) {
                ans++;
                if (end > intervals[idx][1]) {
                    start = intervals[idx][0];
                    end = intervals[idx][1];
                }
            } else {
                start = intervals[idx][0];
                end = intervals[idx][1];
            }
        }

        return ans;
    }

}
