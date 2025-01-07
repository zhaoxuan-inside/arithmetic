package leetcode;

@SuppressWarnings("unused")
public class topic_0509 {

    public static int fib(int n) {

        int[] steps = new int[3];
        steps[1] = 1;

        for (int idx = 2; idx <= n; idx++) {
            // 类似 topic_0070 通过长度为3的数据处理数据
            steps[idx % 3] = steps[(idx - 1) % 3] + steps[(idx - 2) % 3];
        }

        return steps[n % 3];

    }

}