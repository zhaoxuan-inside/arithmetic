package every_day_topic;

public class topic_0062 {

    static int row;
    static int col;

    public static int uniquePaths(int m, int n) {
        row = m;
        col = n;
        return move(1, 1);
    }

    public static int move(int rowCurr, int colCurr) {
        if (rowCurr >= row && colCurr >= col) {
            return 1;
        }

        int tmp = 0;
        if (rowCurr < row) {
            tmp += move(rowCurr + 1, colCurr);
        }

        if (colCurr < col) {
            tmp += move(rowCurr, colCurr + 1);
        }

        return tmp;
    }

    public int better(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
