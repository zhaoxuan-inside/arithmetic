package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0131 {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        int length = s.length();
        int[] mem = new int[length];
        int[] subLength = new int[length];

        for (int end = 0; end < length; end++) {
            for (int start = end - 1; start >= 0; start--) {
                if (checkPalindrome(s.substring(start, end))) {
                    mem[end] = start;
                    subLength[end] = end - start + 1;
                }
            }
        }

        for (int subMaxLen = 1; subMaxLen < length; subMaxLen++) {
            for (int index = 0; index < length; index++) {

            }
        }

        return result;

    }

    private boolean checkPalindrome(String str) {
        return new StringBuffer(str).reverse().toString().equals(str);
    }
}
