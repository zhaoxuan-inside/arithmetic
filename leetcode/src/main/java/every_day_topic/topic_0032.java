package every_day_topic;

public class topic_0032 {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    public static int longestValidParentheses2(String s) {

        int[] matching = new int[s.length()];

        int result = 0;

        for (int end = 1; end < s.length(); end++) {
            if (s.charAt(end) == ')') {
                if (s.charAt(end - 1) == '(') {
                    matching[end] = 2 + (end >= 2 ? matching[end - 2] : 0);
                } else {
                    // 防止越界
                    if (end - matching[end - 1] > 0 &&
                            // 前一个字符的最长匹配括号前一个字符与当前字符匹配
                            s.charAt(end - matching[end - 1] - 1) == '(') {
                        matching[end] = matching[end - 1] + 2;

                        // 匹配完当前节点后的前一个匹配数量
                        if (end - matching[end - 1] - 2 >= 0) {
                            matching[end] += matching[end - matching[end - 1] - 2];
                        }
                    }
                }
                result = Math.max(result, matching[end]);
            }
        }

        return result;

    }

    public static int longestValidParentheses3(String s) {
        int[] matching = new int[s.length()];
        int result = 0;

        for (int end = 1; end < s.length(); end++) {
            if (s.charAt(end) == ')') {
                if (s.charAt(end - 1) == '(') {
                    matching[end] = (end >= 2 ? matching[end - 2] : 0) + 2;
                } else {

                    if (end - matching[end - 1] > 0
                            && s.charAt(end - matching[end - 1] - 1) == '(') {
                        matching[end] = matching[end - 1] + 2;

                        if (end - matching[end - 1] - 2 >= 0) {
                            matching[end] += matching[end - matching[end - 1] - 2];
                        }
                    }
                }
            }

            result = Math.max(result, matching[end]);
        }

        return result;
    }

}