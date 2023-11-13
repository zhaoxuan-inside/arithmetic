package leetcode;

@SuppressWarnings("unused")
public class topic_1137 {

    private static final int NUM = (int) Math.pow(2, 32) - 1;

    public static int tribonacci(int n) {

        if (n < 4) {
            switch (n) {
                case 0 :
                    return 0;
                case 1 :
                case 2:
                    return 1;
            }
        }

        int pre = 0;
        int mid = 1;
        int last = 1;
        int tmp;

        for (int i = 2; i < n; i++) {
            tmp = pre + mid + last;
            pre = mid;
            mid = last;
            last = tmp;
        }
        return last;
    }

    public static int batter(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 | n == 2) {
            return 1;
        }

        return batter(n - 1) + batter(n - 2) + batter(n - 3);

    }

}
