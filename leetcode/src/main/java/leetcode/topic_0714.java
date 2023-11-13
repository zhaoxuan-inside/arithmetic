package leetcode;

@SuppressWarnings("unused")
public class topic_0714 {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] mem = new int[length][2];
        mem[0][0] = 0;
        mem[0][1] = -prices[0];
        for (int index = 1; index < length; ++index) {
            // [index][0]  手里没有股票的最大利润，
            mem[index][0] = Math.max(mem[index - 1][0], mem[index - 1][1] + prices[index] - fee);
            // [index][1]  手里持有一支股票的最大利润
            mem[index][1] = Math.max(mem[index - 1][1], mem[index - 1][0] - prices[index]);
        }
        return mem[length - 1][0];
    }
}
