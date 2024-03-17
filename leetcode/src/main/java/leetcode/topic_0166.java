package leetcode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_0166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        String ans = "";
        if (numerator == 0 || denominator == 0) {
            return "0";
        }

        long numeratorLong = numerator;
        long denominatorLong = denominator;

        int sign = 1;
        if (numeratorLong < 0) {
            sign *= -1;
            numeratorLong *= -1;
        }

        if (denominatorLong < 0) {
            sign *= -1;
            denominatorLong *= -1;
        }

        if (sign < 0) {
            ans += "-";
        }

        ans += numeratorLong / denominatorLong;
        long div = numeratorLong % denominatorLong;
        if (div == 0) {
            return ans;
        }

        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        numeratorLong = div * 10;
        int idx = 0;
        while (div != 0) {
            Integer lastIdx = map.get(div);
            if (lastIdx != null) {
                sb.insert(lastIdx, "(");
                sb.append(")");
                return ans + "." + sb;
            }
            map.put(div, idx++);
            div = numeratorLong % denominatorLong;
            sb.append(numeratorLong / denominatorLong);
            numeratorLong = div * 10;
        }

        ans += "." + sb;
        return ans;
    }

}
