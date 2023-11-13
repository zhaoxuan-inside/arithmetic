package leetcode;

@SuppressWarnings("unused")
public class topic_0516 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int ans = 1;
        int[] mem = new int[length];
        char[] charArray = s.toCharArray();
        mem[0] = 1;
//
//        for (int idx = 1; idx < length; idx++) {
//            int preIdx = idx - 1;
//            if (preIdx >= 0 && ) {
//
//            }
//        }
//

        return ans;
    }
}
