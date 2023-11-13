package leetcode;

@SuppressWarnings("unused")
public class topic_LCP06 {
    public int minCount(int[] coins) {
        int count = 0;

        for (int coin : coins) {
            count += coin / 2;
            if (coin % 2 == 1) {
                count++;
            }
        }

        return count;
    }
}
