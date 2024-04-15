package leetcode;

@SuppressWarnings("unused")
public class topic_0072 {
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        // 有一个字符串为空串
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        // DP 数组
        int[][] mem = new int[len1 + 1][len2 + 1];

        // 边界状态初始化
        for (int idx = 0; idx < len1 + 1; idx++) {
            mem[idx][0] = idx;
        }
        for (int idx = 0; idx < len2 + 1; idx++) {
            mem[0][idx] = idx;
        }

        // 计算所有 DP 值
        for (int word1Idx = 1; word1Idx < len1 + 1; word1Idx++) {
            for (int word2Idx = 1; word2Idx < len2 + 1; word2Idx++) {
                int left = mem[word1Idx - 1][word2Idx] + 1;
                int down = mem[word1Idx][word2Idx - 1] + 1;
                int leftDown = mem[word1Idx - 1][word2Idx - 1];
                if (word1.charAt(word1Idx - 1) != word2.charAt(word2Idx - 1)) {
                    leftDown += 1;
                }
                mem[word1Idx][word2Idx] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return mem[len1][len2];
    }

}
