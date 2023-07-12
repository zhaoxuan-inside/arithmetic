package every_day_topic;

import java.util.HashSet;
import java.util.Set;

public class topic_0073 {

    public static void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            if (rows.contains(row)) {
                continue;
            }
            for (int col = 0; col < matrix[0].length; col++) {
                if (cols.contains(col)) {
                    continue;
                }
                if (matrix[row][col] == 0) {
                    setZero(matrix, row, col);
                    rows.add(row);
                    cols.add(col);
                    break;
                }
            }
        }

    }

    private static void setZero(int[][] matrix, int row, int col) {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }

        for (int i = 0; i < matrix[0].length; i++) {

            matrix[row][i] = 0;

        }

    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}});
    }

}
