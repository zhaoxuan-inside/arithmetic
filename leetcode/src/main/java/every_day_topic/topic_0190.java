package every_day_topic;

@SuppressWarnings("unused")
public class topic_0190 {
    public static int reverseBits(long n) {
        StringBuilder binary = new StringBuilder();

        while (n > 0) {
            binary.append(n % 2);
            n /= 2;
        }

        while (binary.length() < 32) {
            binary.append(0);
        }

        long bit = 1;
        int ans = 0;
        for (int index = binary.length() - 1; index >= 0; index--) {
            char ch = binary.charAt(index);
            ans += (ch - '0') * bit;
            bit *= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        reverseBits(4294967293L);
    }

}
