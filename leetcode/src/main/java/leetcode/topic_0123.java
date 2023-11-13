package leetcode;

@SuppressWarnings("unused")
public class topic_0123 {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int index = 0; index < prices.length; index++) {
            ans = Math.max(ans, subMaxProfit(prices, 0, index) + subMaxProfit(prices, index, prices.length));
        }
        return ans;
    }

    private static int subMaxProfit(int[] prices, int start, int end) {
        int ans = 0;

        for (int endIndex = start; endIndex < end; endIndex++) {
            int curr = 0;
            for (int startIndex = endIndex - 1; startIndex >= start; startIndex--) {
                if (prices[endIndex] <= prices[startIndex]) {
                    break;
                }
                curr = Math.max(curr, prices[endIndex] - prices[startIndex]);
            }
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    public int faster(int[] prices) {
        int length = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int index = 1; index < length; ++index) {
            buy1 = Math.max(buy1, -prices[index]);
            sell1 = Math.max(sell1, buy1 + prices[index]);
            buy2 = Math.max(buy2, sell1 - prices[index]);
            sell2 = Math.max(sell2, buy2 + prices[index]);
        }
        return sell2;
    }

}