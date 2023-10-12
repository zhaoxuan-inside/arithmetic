package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_2596 {
    public static boolean checkValidGrid(int[][] grid) {

        if (grid[0][0] != 0) {
            return false;
        }

        Map<Integer, List<Integer>> next = new HashMap<>();

        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                int curr = grid[row][col];
                List<Integer> nextSteps = new ArrayList<>();
                if (row + 2 < rowLength && col + 1 < colLength) {
                    nextSteps.add(grid[row + 2][col + 1]);
                }
                if (row + 2 < rowLength && col - 1 >= 0) {
                    nextSteps.add(grid[row + 2][col - 1]);
                }
                if (row - 2 >= 0 && col + 1 < colLength) {
                    nextSteps.add(grid[row - 2][col + 1]);
                }
                if (row - 2 >= 0 && col - 1 >= 0) {
                    nextSteps.add(grid[row - 2][col - 1]);
                }

                if (row + 1 < rowLength && col + 2 < colLength) {
                    nextSteps.add(grid[row + 1][col + 2]);
                }
                if (row + 1 < rowLength && col - 2 >= 0) {
                    nextSteps.add(grid[row + 1][col - 2]);
                }
                if (row - 1 >= 0 && col + 2 < colLength) {
                    nextSteps.add(grid[row - 1][col + 2]);
                }
                if (row - 1 >= 0 && col - 2 >= 0) {
                    nextSteps.add(grid[row - 1][col - 2]);
                }
                next.put(curr, nextSteps);
            }
        }

        for (int index = 0; index < rowLength * colLength - 1; index++) {
            if (!next.get(index).contains(index + 1)) {
                return false;
            }
        }

        return true;

    }

    public boolean batter(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[][] indices = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                indices[grid[i][j]][0] = i;
                indices[grid[i][j]][1] = j;
            }
        }
        for (int i = 1; i < n * n; i++) {
            int dx = Math.abs(indices[i][0] - indices[i - 1][0]);
            int dy = Math.abs(indices[i][1] - indices[i - 1][1]);
            if (dx * dy != 2) {
                return false;
            }
        }
        return true;
    }

}
