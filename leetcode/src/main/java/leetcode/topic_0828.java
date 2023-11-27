package leetcode;

@SuppressWarnings("unused")
public class topic_0828 {
    public static int uniqueLetterString(String s) {
        int ans = 0;
        int len = s.length();
        int[][] mem = new int[len][len];
        char[] charList = s.toCharArray();

        for (int start = 0; start < len; start++) {
            mem[start][start] = 1;
            ans++;
            for (int end = start + 1; end < len; end++) {
                int exist = 0;
                for (int idx = start; idx < end; idx++) {
                    if (charList[idx] == charList[end]) {
                        exist++;
                    }
                }
                System.out.print(charList[end]);
                if (exist == 0) {
                    mem[start][end] = mem[start][end - 1] + 1;
                } else if (exist == 1) {
                    mem[start][end] = mem[start][end - 1] - 1;
                } else {
                    mem[start][end] = mem[start][end - 1];
                }
                ans += mem[start][end];
            }
        }
        return ans;
    }

}
