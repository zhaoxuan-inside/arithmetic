package leetcode;

@SuppressWarnings("unused")
public class topic_0509 {
    public static int fib(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        return fib(n - 1) + fib(n - 2);
    }

    public static int faster(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        int[] mem = new int[]{0, 1, 1};

        int idx = 2;
        int count = 2;
        while (count++ <= n) {
            mem[idx] = mem[((idx - 1) + 3) % 3] + mem[((idx - 2) + 3) % 3];
            idx = (idx + 1) % 3;
        }
        return mem[((idx - 1) + 3) % 3];
    }

}