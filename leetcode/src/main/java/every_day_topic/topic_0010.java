package every_day_topic;

@SuppressWarnings("unused")
public class topic_0010 {
    public boolean isMatch(String s, String p) {

        int stringLength = s.length();
        int patternLength = p.length();

        boolean[][] dp = new boolean[stringLength + 1][patternLength + 1];

        dp[0][0] = true;

        for (int stringIndex = 0; stringIndex <= stringLength; stringIndex++) {
            for (int patternIndex = 1; patternIndex <= patternLength; patternIndex++) {

                if (p.charAt(patternIndex - 1) != '*') { // 非*匹配
                    if (stringIndex >= 1 && //
                            (s.charAt(stringIndex - 1) == p.charAt(patternIndex - 1) ||  // 字符匹配
                                    p.charAt(patternIndex - 1) == '.')) { // . 匹配

                        dp[stringIndex][patternIndex] = dp[stringIndex - 1][patternIndex - 1];

                    }
                } else {
                    if (patternIndex >= 2 &&
                            stringIndex >= 1 &&
                            (p.charAt(patternIndex - 2) == s.charAt(stringIndex - 1) ||
                                    p.charAt(patternIndex - 2) == '.')) {

                        dp[stringIndex][patternIndex] = dp[stringIndex - 1][patternIndex];

                    }

                    if (patternIndex >= 2) {

                        dp[stringIndex][patternIndex] |= dp[stringIndex][patternIndex - 2];

                    }

                }
            }
        }

        return dp[stringLength][patternLength];

    }

}