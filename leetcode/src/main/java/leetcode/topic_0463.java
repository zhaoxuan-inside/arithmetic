package leetcode;

@SuppressWarnings("unused")
public class topic_0463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                if (grid[row][col] == 1) {
                    if (row > 0 && grid[row - 1][col] == 0 || row == 0) {
                        ans++;
                    }
                    if (col > 0 && grid[row][col - 1] == 0 || col == 0) {
                        ans++;
                    }
                    if (row < rowLen - 1 && grid[row + 1][col] == 0 || row == rowLen - 1) {
                        ans++;
                    }
                    if (col < colLen - 1 && grid[row][col + 1] == 0 || col == colLen - 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
