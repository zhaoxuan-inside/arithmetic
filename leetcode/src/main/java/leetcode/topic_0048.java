package leetcode;

@SuppressWarnings("unused")
public class topic_0048 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int row = 0; row < len / 2; row++) {
            for (int col = 0; col < len; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[len - row - 1][col];
                matrix[len - row - 1][col] = tmp;
            }
        }

        for (int row = 0; row < len; row++) {
            for (int col = row; col < len; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }

}
