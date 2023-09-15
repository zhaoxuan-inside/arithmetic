package every_day_topic;

import java.util.ArrayList;
import java.util.List;

public class topic_2432 {
    public static int hardestWorker(int n, int[][] logs) {
        int maxTime = Integer.MIN_VALUE;
        List<Integer> maxTimeUserIds = new ArrayList<>();
        int last = 0;
        for (int[] log : logs) {
            int gap = log[1] - last;
            last = log[1];
            if (gap > maxTime) {
                maxTime = gap;
                maxTimeUserIds.clear();
                maxTimeUserIds.add(log[0]);
                continue;
            }
            if (gap == maxTime) {
                maxTimeUserIds.add(log[0]);
            }
        }

        maxTimeUserIds.sort(Integer::compareTo);
        return maxTimeUserIds.get(0);

    }

}
