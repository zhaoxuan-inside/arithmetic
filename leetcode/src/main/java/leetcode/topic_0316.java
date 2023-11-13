package leetcode;

@SuppressWarnings("unused")
public class topic_0316 {

    public static String removeDuplicateLetters(String s) {

        boolean[] visits = new boolean[26];

        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (!visits[ch - 'a']) {
                removeBiggerChars(charCounts, visits, result, ch);
                visits[ch - 'a'] = true;
                result.append(ch);
            }
            charCounts[ch - 'a'] -= 1;
        }
        return result.toString();
    }

    private static void removeBiggerChars(int[] charCounts, boolean[] vis, StringBuilder result, char ch) {
        while (result.length() > 0 && result.charAt(result.length() - 1) > ch) {
            if (charCounts[result.charAt(result.length() - 1) - 'a'] > 0) {
                vis[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            } else {
                break;
            }
        }
    }

}
