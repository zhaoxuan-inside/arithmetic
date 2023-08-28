package every_day_topic;

public class topic_0058 {
    public static int lengthOfLastWord(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        s = s.trim();
        int i = s.lastIndexOf(' ');
        return s.substring(i + 1, s.length()).length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }
}
