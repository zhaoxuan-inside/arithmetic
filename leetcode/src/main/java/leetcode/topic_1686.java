package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_1686 {
    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int len = aliceValues.length;

        int[][] gaps = new int[len][2];

        for (int idx = 0; idx < len; idx++) {
            gaps[idx][0] = aliceValues[idx] + bobValues[idx];
            gaps[idx][1] = idx;
        }

        Arrays.sort(gaps, (gap1, gap2) -> {
            if (gap1[0] > gap2[0]) {
                return 1;
            }

            if (gap1[0] < gap2[0]) {
                return -1;
            }

            return Integer.compare(aliceValues[gap1[1]], aliceValues[gap2[1]]);

        });

        int ans = 0;

        for (int idx = len - 1; idx >= 0; idx = idx - 2) {
            ans += aliceValues[gaps[idx][1]] - (idx > 0 ? bobValues[gaps[idx - 1][1]] : 0);
        }

        return Integer.compare(ans, 0);

    }

    public static void main(String[] args) {
        stoneGameVI(new int[]{2, 1}, new int[]{3, 1});  // 3 10 10
    }
}
