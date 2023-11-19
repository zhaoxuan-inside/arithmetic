package leetcode;

@SuppressWarnings("unused")
public class compete_100119 {

    private final static long MAX_NUM = (long) (Math.pow(10, 9) + 7);

    public static int maximumXorProduct(long a, long b, int n) {
        long ans = (a * b) % MAX_NUM;
        for (int idx = 0; idx < (int) Math.pow(2, n); idx++) {
            long currA = a;
            long currB = b;

            currA ^= idx;
            currB ^= idx;

            currA %= MAX_NUM;
            currB %= MAX_NUM;

            long curMulti = (currB * currA) % MAX_NUM;
            ans = Math.max(ans, curMulti);
        }

        return (int) (ans % MAX_NUM);
    }

}
