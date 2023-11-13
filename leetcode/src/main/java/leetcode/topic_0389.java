package leetcode;

@SuppressWarnings("unused")
public class topic_0389 {
    public char findTheDifference(String s, String t) {
        int[] mem = new int[26];
        for (char ch : s.toCharArray()) {
            mem[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (mem[ch - 'a'] == 0) {
                return ch;
            } else {
                mem[ch - 'a']--;
            }
        }
        return 'a';
    }
}
