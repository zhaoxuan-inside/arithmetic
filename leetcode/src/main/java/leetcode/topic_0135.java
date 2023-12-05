package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_0135 {
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] candy = new int[length];
        Arrays.fill(candy, 1);

        for (int idx = 1; idx < length; idx++) {
            if (ratings[idx] > ratings[idx - 1]) {
                candy[idx] = candy[idx - 1] + 1;
            }
        }

        int ans = 0;
        for (int idx = length - 1; idx > 0; idx--) {
            if (ratings[idx] < ratings[idx - 1]) {
                candy[idx - 1] = Math.max(candy[idx] + 1, candy[idx - 1]);
            }
            ans += candy[idx];
        }
        ans += candy[0];
        return ans;

    }

}
