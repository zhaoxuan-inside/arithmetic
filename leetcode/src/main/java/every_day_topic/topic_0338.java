package every_day_topic;

public class topic_0338 {
    public static int[] countBits(int n) {

        int[] result = new int[n + 1];
        result[0] = 0;

        int length = (int) Math.sqrt(n) + 1;
        int[] bit = new int[length];

        for (int index = 1; index < n + 1; index++) {
            int tmp = 1;
            int count = 0;
            int currMax = 0;
            for (int i = 0; i < length; i++) {
                int curr = bit[i] + tmp;
                bit[i] = curr % 2;
                tmp = curr / 2;
                if (bit[i] == 1) {
                    count++;
                }
            }
            if (tmp == 1) {
                count++;
            }
            result[index] = count;
        }

        return result;
    }

}
