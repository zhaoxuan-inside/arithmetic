package every_day_topic;

@SuppressWarnings("unused")
public class topic_0070 {
    public static int climbStairs(int n) {
        return types(n);
    }

    private static int types(int n) {
        if (n > 2) {
            return types(n - 1) + types(n - 2);
        }

        if (n == 2) {
            return 2;
        }

        if (n == 1) {
            return 1;
        }

        return 0;

    }

    public int batter(int n) {
        int[] arr = new int[45];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

}
