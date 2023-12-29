package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int cast = prices[0] + prices[1];
        return money >= cast ? money - cast : money;
    }
}
