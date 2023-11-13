package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_2500 {
    public int deleteGreatestValue(int[][] grid) {

        int result = 0;

        for (int[] ints : grid) {
            Arrays.sort(ints);
        }

        for (int col = 0; col < grid[0].length; col++) {

            int max = grid[0][col];

            for (int row = 1; row < grid.length; row++) {
                max = Math.max(max, grid[row][col]);
            }

            result += max;

        }

        return result;

    }
}
