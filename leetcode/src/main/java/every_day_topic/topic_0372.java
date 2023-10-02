package every_day_topic;

@SuppressWarnings("unused")
public class topic_0372 {
    public static int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % 1337);
            a = pow(a, 10);
        }
        return ans;
    }

    private static int pow(int a, int b) {
        int ans = 1;
        a %= 1337;
        for (int i = b; i > 0; i /= 2) {
            if (i % 2 != 0) {
                ans *= a;
                ans %= 1337;
            }
            a *= a;
            a %= 1337;
        }
        return ans;
    }

    public static void main(String[] args) {
        superPow(2147483647, new int[]{2, 0, 0});
    }
}
