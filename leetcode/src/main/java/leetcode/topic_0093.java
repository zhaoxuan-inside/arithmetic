package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0093 {
    private static List<String> ans;

    public static List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        analyseIP(new StringBuilder(), s, 0);
        return ans;
    }

    private static void analyseIP(StringBuilder sb, String str, int start) {
        if (sb.toString().split("\\.").length == 4) {
            if (start >= str.length()) {
                ans.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        if (validNum(str, start, 1)) {
            StringBuilder append = new StringBuilder(sb).append(str.charAt(start)).append('.');
            analyseIP(append, str, start + 1);
        }
        if (validNum(str, start, 2)) {
            StringBuilder append = new StringBuilder(sb).append(str, start, start + 2).append('.');
            analyseIP(append, str, start + 2);
        }
        if (validNum(str, start, 3)) {
            StringBuilder append = new StringBuilder(sb).append(str, start, start + 3).append('.');
            analyseIP(append, str, start + 3);
        }
    }

    private static boolean validNum(String num, int start, int len) {
        if (len > 3 || start + len > num.length()) {
            return false;
        }
        if (num.charAt(start) == '0' && len > 1) {
            return false;
        }
        int i = Integer.parseInt(num.substring(start, start + len));
        return i >= 0 && i <= 255;
    }

}
