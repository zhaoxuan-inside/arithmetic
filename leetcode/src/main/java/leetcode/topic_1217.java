package leetcode;

@SuppressWarnings("unused")
public class topic_1217 {
    public static int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }

}
