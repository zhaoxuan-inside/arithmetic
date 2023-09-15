package every_day_topic;

import java.util.Arrays;

public class topic_0050 {
    public int giveGem(int[] gem, int[][] operations) {

        for (int[] operation : operations) {
            int swap = gem[operation[0]] / 2;
            gem[operation[0]] -= swap;
            gem[operation[1]] += swap;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : gem) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return max - min;
    }
}
