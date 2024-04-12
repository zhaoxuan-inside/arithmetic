package leetcode;

@SuppressWarnings("unused")
public class topic_0059 {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int idx = 1;
        int dir = 0;
        int row = 0;
        int col = 0;
        while (idx <= n * n) {
            ans[row][col] = idx++;
            switch (dir) {
                case 0:
                    if (col + 1 >= n || ans[row][col + 1] != 0) {
                        row++;
                        dir = 1;
                    } else {
                        col++;
                    }
                    break;
                case 1:
                    if (row + 1 >= n || ans[row + 1][col] != 0) {
                        dir = 2;
                        col--;
                    } else {
                        row++;
                    }
                    break;
                case 2:
                    if (col - 1 < 0 || ans[row][col - 1] != 0) {
                        dir = 3;
                        row--;
                    } else {
                        col--;
                    }
                    break;
                case 3:
                    if (row - 1 < 0 || ans[row - 1][col] != 0) {
                        dir = 0;
                        col++;
                    } else {
                        row--;
                    }
                    break;
            }
        }
        return ans;
    }

}
