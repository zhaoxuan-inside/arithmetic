package leetcode;

public class topic_0151 {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        for (char ch : chars) {
            if (ch == ' ') {
                if (currentWord.length() > 0) {
                    sb.insert(0, currentWord);
                    sb.insert(0, ' ');
                    currentWord.delete(0, currentWord.length());
                }
                continue;
            }
            currentWord.append(ch);
        }
        if (currentWord.length() > 0) {
            sb.insert(0, currentWord);
        } else if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}
