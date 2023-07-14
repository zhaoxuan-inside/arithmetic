package every_day_topic;

@SuppressWarnings("unused")
public class topic_0931 {
    public int minFallingPathSum(int[][] matrix) {

        int length = matrix.length;
        int res = Integer.MAX_VALUE;

        for (int row = 1; row < length; row++) {
            for (int col = 0; col < length; col++) {

                if (col == 0) {
                    matrix[row][col] += Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]);
                } else if (col == length - 1) {
                    matrix[row][col] += Math.min(matrix[row - 1][col - 1], matrix[row - 1][col]);
                } else {
                    matrix[row][col] += Math.min(matrix[row - 1][col - 1], Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]));
                }

            }
        }
        for (int j = 0; j < length; j++) {
            res = Math.min(res, matrix[length - 1][j]);
        }
        return res;
    }

}
