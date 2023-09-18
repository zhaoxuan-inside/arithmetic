package every_day_topic;

@SuppressWarnings("unused")
public class topic_0367 {
    public static boolean isPerfectSquare(int num) {
        double x = Math.exp(Math.log(num) / 2);
        return (int) x * (int) x == num || ((int) x + 1) * ((int) x + 1) == num;
    }
}
