package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0179 {

    public static String largestNumber(int[] nums) {

        List<String> numStrs = new ArrayList<>();

        for (int num : nums) {
            numStrs.add(String.valueOf(num));
        }

        numStrs.sort((num1, num2) -> {
            String tmp1 = num1 + num2;
            String tmp2 = num2 + num1;
            return tmp1.compareTo(tmp2);
        });

        StringBuilder sb = new StringBuilder();

        for (String numStr : numStrs) {
            sb.insert(0, numStr);
        }

        String str = sb.toString();

        for (int idx = 0; idx < str.length(); idx++) {
            if (str.charAt(idx) != '0') {
                return str.substring(idx);
            }
            if (idx == str.length() - 1) {
                return "0";
            }
        }

        return sb.toString();

    }

}
