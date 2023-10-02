package every_day_topic;

@SuppressWarnings("unused")
public class topic_0122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int pre = prices[0];
        for (int price : prices) {
            int gap = price - pre;
            if (gap > 0) {
                ans += gap;
            }
            pre = price;
        }
        return ans;
    }
}
