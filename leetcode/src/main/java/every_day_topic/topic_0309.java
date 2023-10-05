package every_day_topic;

@SuppressWarnings("unused")
public class topic_0309 {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int length = prices.length;
        int[][] mem = new int[length][3];
        mem[0][0] = -prices[0];

        for (int index = 1; index < length; ++index) {
            mem[index][0] = Math.max(mem[index - 1][0], mem[index - 1][2] - prices[index]);
            mem[index][1] = mem[index - 1][0] + prices[index];
            mem[index][2] = Math.max(mem[index - 1][1], mem[index - 1][2]);
        }
        return Math.max(mem[length - 1][1], mem[length - 1][2]);
    }
}
