package leetcode;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unused")
public class topic_0056 {
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int curr = 0;
        int scan = 1;

        while (scan < intervals.length) {
            if (Math.max(intervals[curr][0], intervals[scan][0]) <= Math.min(intervals[curr][1], intervals[scan][1])) {
                intervals[curr][0] = Math.min(intervals[curr][0], intervals[scan][0]);
                intervals[curr][1] = Math.max(intervals[curr][1], intervals[scan][1]);
            } else {
                curr++;
                intervals[curr] = intervals[scan];
            }
            scan++;
        }

        return Arrays.copyOfRange(intervals, 0, curr + 1);

    }

}
