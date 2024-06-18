package leetcode;

@SuppressWarnings("unused")
public class topic_0521 {
    public static int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
