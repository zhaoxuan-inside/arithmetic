package every_day_topic;

@SuppressWarnings("unused")
public class topic_0849 {
    public static int maxDistToClosest(int[] seats) {
        int max = 0;

        int pre = 0;
        int last = 0;
        int length = seats.length;

        while (last <= length - 1) {
            if (seats[last] == 0) {
                ++last;
                if (last < length - 1) {
                    continue;
                }
                if (last >= length) {
                    return max;
                }
            }

            int gap = last - pre;
            if ((last < length - 1 && seats[pre] == 1) || (seats[last] == 1 && seats[pre] == 1)) {
                gap = gap / 2;
            }
            max = Math.max(gap, max);
            pre = last;
            last++;
        }

        return max;

    }

}
