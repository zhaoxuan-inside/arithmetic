package leetcode;

@SuppressWarnings("unused")
public class topic_0091 {
    public static int numDecodings(String s) {
        int len = s.length();
        int[] mem = new int[len + 1];
        mem[0] = 1;
        for (int idx = 1; idx <= len; ++idx) {
            if (s.charAt(idx - 1) != '0') {
                mem[idx] += mem[idx - 1];
            }
            if (idx > 1 && s.charAt(idx - 2) != '0' &&
                    ((s.charAt(idx - 2) - '0') * 10 + (s.charAt(idx - 1) - '0') <= 26)) {
                mem[idx] += mem[idx - 2];
            }
        }
        return mem[len];
    }
}
