package leetcode;

@SuppressWarnings("unused")
public class topic_0058 {
    public static int lengthOfLastWord(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        s = s.trim();
        int i = s.lastIndexOf(' ');
        return s.substring(i + 1).length();
    }

}
