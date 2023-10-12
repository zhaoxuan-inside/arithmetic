package every_day_topic;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_2517 {

    public static int maximumTastiness(int[] price, int k) {

        Arrays.sort(price);

        int left = 0;
        int avgGap = (price[price.length - 1] - price[0]) / (k - 1) + 1;

        while (left + 1 < avgGap) {

            int mid = left + (avgGap - left) / 2;

            if (f(price, mid) >= k) {
                left = mid;
            } else {
                avgGap = mid;
            }

        }

        return left;

    }

    private static int f(int[] prices, int d) {

        int cnt = 1;
        int pre = prices[0];

        for (int price : prices) {

            if (price >= pre + d) {
                cnt++;
                pre = price;
            }

        }

        return cnt;

    }

}
