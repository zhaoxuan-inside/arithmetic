package every_day_topic;

public class topic_0005 {
    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();

        int begin = 0;
        int max = 1;

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + max; end < s.length(); end++) {
                if (ifPalindromicNumber(charArray, start, end)) {
                    int length = end - start + 1;
                    if (length > max) {
                        max = length;
                        begin = start;
                    }
                }
            }
        }

        return String.copyValueOf(charArray, begin, max);

    }

    private static boolean ifPalindromicNumber(char[] chars, int start, int end) {

        if (start >= end) {
            return true;
        }

        while (start < end) {

            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
