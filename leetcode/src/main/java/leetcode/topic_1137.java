package leetcode;

@SuppressWarnings("unused")
public class topic_1137 {

    private static final int NUM = (int) Math.pow(2, 32) - 1;

    public static int tribonacci(int n) {

        long[] steps = new long[3];
        steps[1] = 1;
        steps[2] = 1;

        for (int idx = 3; idx <= n; idx++) {
            long tmp = steps[(idx - 1) % 3] + steps[(idx - 2) % 3] + steps[(idx - 3) % 3];
            tmp = tmp % NUM;
            steps[idx % 3] = tmp;
        }

        return (int) steps[n % 3];

    }

}
