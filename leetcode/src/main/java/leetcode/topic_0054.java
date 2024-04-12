package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int total = matrix.length * matrix[0].length;
        List<Integer> ans = new ArrayList<>(total);
        int row = 0;
        int col = 0;
        int dir = 0;
        while (total > 0) {
            ans.add(matrix[row][col]);
            matrix[row][col] = Integer.MIN_VALUE;
            switch (dir) {
                case 0:
                    if (col + 1 >= colLen || matrix[row][col + 1] == Integer.MIN_VALUE) {
                        row++;
                        dir = 1;
                    } else {
                        col++;
                    }
                    break;
                case 1:
                    if (row + 1 >= rowLen || matrix[row + 1][col] == Integer.MIN_VALUE) {
                        dir = 2;
                        col--;
                    } else {
                        row++;
                    }
                    break;
                case 2:
                    if (col - 1 < 0 || matrix[row][col - 1] == Integer.MIN_VALUE) {
                        dir = 3;
                        row--;
                    } else {
                        col--;
                    }
                    break;
                case 3:
                    if (row - 1 < 0 || matrix[row - 1][col] == Integer.MIN_VALUE) {
                        dir = 0;
                        col++;
                    } else {
                        row--;
                    }
                    break;
            }
            total--;
        }
        return ans;
    }

}
