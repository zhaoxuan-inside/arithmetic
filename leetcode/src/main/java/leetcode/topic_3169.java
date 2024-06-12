package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_3169 {
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int count = meetings[0][0] - 1;

        int end = meetings[0][1];
        for (int idx = 1; idx < meetings.length; idx++) {
            if (end < meetings[idx][0]) {
                count += meetings[idx][0] - end - 1;
                end = meetings[idx][1];
                continue;
            }
            end = Math.max(end, meetings[idx][1]);
        }


        return count + days - end;
    }
}
