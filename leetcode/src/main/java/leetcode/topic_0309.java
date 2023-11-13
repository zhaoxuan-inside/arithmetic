package leetcode;

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
            // f[i][0]: 手上持有股票的最大收益
            // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
            // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
            mem[index][0] = Math.max(mem[index - 1][0], mem[index - 1][2] - prices[index]);
            mem[index][1] = mem[index - 1][0] + prices[index];
            mem[index][2] = Math.max(mem[index - 1][1], mem[index - 1][2]);
        }
        return Math.max(mem[length - 1][1], mem[length - 1][2]);
    }
}
