package leetcode;

@SuppressWarnings("unused")
public class topic_0063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowCount = obstacleGrid.length;
        int colCount = obstacleGrid[0].length;

        int[][] mem = new int[rowCount][colCount];

        for (int index = 0; index < colCount; index++) {
            if (obstacleGrid[0][index] == 1) {
                break;
            }
            mem[0][index] = 1;
        }

        for (int index = 0; index < rowCount; index++) {
            if (obstacleGrid[index][0] == 1) {
                break;
            }
            mem[index][0] = 1;
        }

        for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
            for (int colIndex = 1; colIndex < colCount; colIndex++) {
                if (obstacleGrid[rowIndex][colIndex] != 1) {
                    mem[rowIndex][colIndex] = mem[rowIndex - 1][colIndex] + mem[rowIndex][colIndex - 1];
                }
            }
        }

        return mem[rowCount - 1][colCount - 1];

    }
}
