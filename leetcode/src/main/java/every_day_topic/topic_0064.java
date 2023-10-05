package every_day_topic;

@SuppressWarnings("unused")
public class topic_0064 {
    public static int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] mem = new int[rowLen][colLen];
        mem[0][0] = grid[0][0];

        for (int col = 1; col < colLen; col++) {
            mem[0][col] = mem[0][col - 1] + grid[0][col];
        }

        for (int row = 1; row < rowLen; row++) {
            mem[row][0] = mem[row - 1][0] + grid[row][0];
        }

        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {
                mem[row][col] = Math.min(mem[row - 1][col], mem[row][col - 1]) + grid[row][col];
            }
        }

        return mem[rowLen - 1][colLen - 1];
    }

    private static class Faster {
        public int minPathSum(int[][] grid) {
            int rowLen = grid.length;
            int colLen = grid[0].length;

            int[][] memo = new int[rowLen][colLen];

            return dp(memo, grid, rowLen - 1, colLen - 1);
        }

        public int dp(int[][] memo, int[][] grid, int rowIndex, int colIndex) {
            if (rowIndex == 0 && colIndex == 0) {
                return grid[0][0];
            }

            if (rowIndex < 0 || colIndex < 0) {
                return Integer.MAX_VALUE;
            }

            if (memo[rowIndex][colIndex] == 0) {
                memo[rowIndex][colIndex] = Math.min(dp(memo, grid, rowIndex - 1, colIndex),
                        dp(memo, grid, rowIndex, colIndex - 1)) + grid[rowIndex][colIndex];
            }

            return memo[rowIndex][colIndex];
        }
    }

}
