package leetcode;

@SuppressWarnings("unused")
public class topic_1446 {
    public static int maxPower(String s) {
        int max = 1;
        int[] mem = new int[s.length()];

        char pre = s.charAt(0);
        mem[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == pre) {
                mem[i] = mem[i - 1] + 1;
            } else {
                mem[i] = 1;
            }
            pre = ch;
            if (mem[i] > max) {
                max = mem[i];
            }
        }

        return max;
    }

}
