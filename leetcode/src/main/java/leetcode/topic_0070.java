package leetcode;

@SuppressWarnings("unused")
public class topic_0070 {
    public static int climbStairs(int n) {

        int[] steps = new int[45];

        // 走到第一个位置只有一种方法；
        steps[0] = 1;
        // 走到第二个位置有两种办法；
        steps[1] = 2;

        for (int idx = 2; idx < n; idx++) {
            // 第N步，有两种方法达到，通过N - 1走1阶，通过N - 2走2阶
            steps[idx] = steps[idx - 1] + steps[idx - 2];
        }

        return steps[n - 1];

    }

}
