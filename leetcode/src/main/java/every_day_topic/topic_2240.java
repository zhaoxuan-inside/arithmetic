package every_day_topic;

@SuppressWarnings("unused")
public class topic_2240 {
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long result = 0;
        long maxPen = total / cost1;

        for (long penCount = 0; penCount <= maxPen; penCount++) {
            long remain = total - cost1 * penCount;
            long maxBuyPencil = remain / cost2;
            result += (maxBuyPencil + 1);
        }
        return result;
    }

}
