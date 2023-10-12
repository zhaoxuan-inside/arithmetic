package every_day_topic;

@SuppressWarnings("unused")
public class topic_2511 {
    public static int captureForts(int[] forts) {
        int max = 0;
        int last = -1;

        for (int index = 0; index < forts.length; index++) {
            int curr = forts[index];
            if (curr == 1 || curr == -1) {
                if (last != -1) {
                    if (forts[last] != curr) {
                        max = Math.max(max, index - last - 1);
                    }
                }
                last = index;
            }
        }
        return max;
    }

}
