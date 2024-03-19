package leetcode;

@SuppressWarnings("unused")
public class topic_0007 {
    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        sb.reverse();
        long num = Long.parseLong(sb.toString());
        if (x > 0 && num < Integer.MAX_VALUE) {
            return (int) num;
        }

        if (x < 0 && -1 * num > Integer.MIN_VALUE) {
            return (int) (-1 * num);
        }

        return 0;
    }

    public static int better(int x) {
        int ans = 0;

        while (x != 0) {
            int div = x % 10;
            if (ans > Integer.MAX_VALUE / 10 ||
                    (ans == Integer.MAX_VALUE / 10 && div > Integer.MAX_VALUE % 10) ||
                    ans < Integer.MIN_VALUE / 10 ||
                    (ans == Integer.MIN_VALUE / 10 && div < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            ans = ans * 10 + div;
            x /= 10;
        }

        return ans;
    }

}
