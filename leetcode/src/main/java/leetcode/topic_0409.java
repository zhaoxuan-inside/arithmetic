package leetcode;

@SuppressWarnings("unused")
public class topic_0409 {
    public static int longestPalindrome(String s) {
        int[] mem = new int[52];

        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (ch >= 65 && ch <= 90) {
                mem[ch - 'A']++;
            } else {
                mem[ch - 'a' + 26]++;
            }
        }

        int result = 0;
        boolean remain = false;
        for (Integer count : mem) {
            if (!remain && count % 2 == 1) {
                remain = true;
            }
            result += count / 2 * 2;
        }

        return result + (remain ? 1 : 0);

    }

}
