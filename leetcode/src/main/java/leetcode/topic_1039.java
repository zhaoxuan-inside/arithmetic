package leetcode;

import java.util.HashMap;
import java.util.Map;

public class topic_1039 {
    int pots;
    int[] values;
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minScoreTriangulation(int[] values) {
        this.pots = values.length;
        this.values = values;
        return calculateSubGraphMinResult(0, pots - 1);
    }

    public int calculateSubGraphMinResult(int start, int end) {

        // 不能构成三角形
        if (start + 2 > end) {
            return 0;
        }

        // 构成一个三角形
        if (start + 2 == end) {
            return values[start] * values[start + 1] * values[end];
        }

        // 区分每个点开始的数据
        int key = start * pots + end;

        // 没有扫描过
        if (!memo.containsKey(key)) {
            int minScore = Integer.MAX_VALUE;


            for (int middle = start + 1; middle < end; middle++) {
                minScore = Math.min(minScore,
                        values[start] * values[middle] * values[end] + calculateSubGraphMinResult(start, middle) + calculateSubGraphMinResult(middle, end));
            }
            memo.put(key, minScore);
        }
        return memo.get(key);
    }

}