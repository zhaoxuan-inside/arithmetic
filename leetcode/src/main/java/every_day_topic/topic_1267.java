package every_day_topic;

public class topic_1267 {
    public static int countServers(int[][] grid) {
        boolean[] canConn = new boolean[grid.length];
        int result = 0;

        for (int row = 0; row < grid.length; row++) {
            int tmpTotal = 0;
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    tmpTotal++;
                }
            }
            if (tmpTotal > 1) {
                canConn[row] = true;
                result += tmpTotal;
            }
        }

        for (int col = 0; col < grid[0].length; col++) {
            int tmpTotal = 0;
            int dup = 0;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    tmpTotal++;
                    if (canConn[row]) {
                        dup++;
                    }
                }
            }
            if (tmpTotal > 1) {
                result += tmpTotal;
                result -= dup;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countServers(new int[][]{{1, 0}, {1, 1}}));
    }
}
