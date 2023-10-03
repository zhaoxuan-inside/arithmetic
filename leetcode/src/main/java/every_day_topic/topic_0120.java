package every_day_topic;

import java.util.List;

@SuppressWarnings("unused")
public class topic_0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] mem = new int[length][length];
        mem[0][0] = triangle.get(0).get(0);

        for (int row = 1; row < length; ++row) {
            mem[row][0] = mem[row - 1][0] + triangle.get(row).get(0);
            for (int col = 1; col < row; ++col) {
                mem[row][col] = Math.min(mem[row - 1][col - 1], mem[row - 1][col]) + triangle.get(row).get(col);
            }
            mem[row][row] = mem[row - 1][row - 1] + triangle.get(row).get(row);
        }

        int minTotal = mem[length - 1][0];
        for (int i = 1; i < length; ++i) {
            minTotal = Math.min(minTotal, mem[length - 1][i]);
        }
        return minTotal;
    }
}
