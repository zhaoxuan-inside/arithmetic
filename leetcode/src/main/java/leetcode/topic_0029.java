package leetcode;

@SuppressWarnings("unused")
public class topic_0029 {
    public static int divide(int dividend, int divisor) {

        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        String binaryString = Long.toBinaryString(divisorAbs);

        for (int idx = binaryString.length() - 1; idx >= 0; idx--) {
            char curr = binaryString.charAt(idx);
            if (curr == '1') {
                dividendAbs = dividendAbs >> binaryString.length() - 1 - idx;
            }
        }

        boolean single = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        if (single) {
            if (dividendAbs >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) dividendAbs;
        } else {
            if (-dividendAbs <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return -(int) dividendAbs;
        }

    }

}
