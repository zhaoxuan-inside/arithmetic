package every_day_topic;

@SuppressWarnings("unused")
public class topic_0231 {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        while (n > 1 && n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

}
