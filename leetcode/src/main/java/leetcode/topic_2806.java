package leetcode;

@SuppressWarnings("unused")
public class topic_2806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - purchaseAmount - (purchaseAmount % 10 >= 5 ? (10 - purchaseAmount % 10) : -1 * purchaseAmount % 10);
    }
}