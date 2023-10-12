package every_day_topic;

@SuppressWarnings("unused")
public class topic_2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int minIndex = Math.max(startPos - k, 0);
        int maxIndex = Math.min(startPos + k, fruits.length);

        int[] mem = new int[fruits.length];

        int result = 0;

        int path = 0;
        while (path <= k) {


            path++;
        }

        return result;
    }

}
