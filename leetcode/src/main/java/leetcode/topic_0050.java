package leetcode;

@SuppressWarnings("unused")
public class topic_0050 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (x > 0) {
            return Math.exp(Math.log(x) * n);
        } else {
            int ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= x;
            }
            return ans;
        }
    }

    public double faster(double x, int n) {
        double ans = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                ans *= x;
            }
            x = x * x;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
