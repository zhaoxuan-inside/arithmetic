package leetcode;

@SuppressWarnings("unused")
public class topic_0073 {

    public static void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int nodeCount = rowCount * colCount;
        int[][] zeros = new int[nodeCount][2];
        int zeroNodeCount = 0;

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (matrix[row][col] == 0) {
                    zeros[zeroNodeCount][0] = row;
                    zeros[zeroNodeCount][1] = col;
                    zeroNodeCount++;
                }
            }
        }

        for (int index = 0; index < zeroNodeCount; index++) {
            int row = zeros[index][0];
            int col = zeros[index][1];
            for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
                matrix[rowIdx][col] = 0;
            }
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                matrix[row][colIdx] = 0;
            }
        }
    }

}
