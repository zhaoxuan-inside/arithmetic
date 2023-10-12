package every_day_topic;

@SuppressWarnings("unused")
public class topic_2682 {
    public static int[] circularGameLosers(int n, int k) {
        boolean[] bool = new boolean[n];
        int remain = n;

        int index = 0;
        int count = 0;
        while (!bool[index]) {
            bool[index] = true;
            remain--;
            index = (index + ++count * k) % n;
        }

        int[] result = new int[remain];
        index = 0;
        for (int i = 0; i < n; i++) {
            if (!bool[i]) {
                result[index++] = i + 1;
            }
        }

        return result;
    }

}
