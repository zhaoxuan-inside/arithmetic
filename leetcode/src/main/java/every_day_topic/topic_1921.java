package every_day_topic;

@SuppressWarnings("unused")
public class topic_1921 {

    public static int eliminateMaximum(int[] dist, int[] speed) {
        double[] time = new double[dist.length];
        for (int index = 0; index < dist.length; index++) {
            time[index] = (double) dist[index] / speed[index];
        }

        for (int fireCount = 0; fireCount < dist.length; fireCount++) {
            int count = 0;
            for (int index = 0; index < dist.length; index++) {
                if (fireCount >= time[index]) {
                    count++;
                }
            }
            if (fireCount < count) {
                return fireCount;
            }
        }
        return dist.length;
    }

}
