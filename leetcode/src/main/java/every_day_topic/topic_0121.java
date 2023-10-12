package every_day_topic;

@SuppressWarnings("unused")
public class topic_0121 {
    public static int maxProfit(int[] prices) {

        int max = 0;

        for (int end = 1; end < prices.length; end++) {
            for (int start = end - 1; start >= 0; start--) {
                max = Math.max(max, prices[end] - prices[start]);
            }
        }

        return max;
    }

    public static int batterMaxProfit(int[] prices) {
        int maxn = 0, minn = prices[0];

        for (int price : prices) {
            minn = Math.min(minn, price);
            maxn = Math.max(maxn, price - minn);
        }

        return maxn;
    }

}
