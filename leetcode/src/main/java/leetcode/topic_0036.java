package leetcode;

@SuppressWarnings("unused")
public class topic_0036 {
    public static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        int[][] mem = new int[2][10];
        int count = 0;
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                int idx = board[row][col] - '0';
                if (idx > 0 && idx < 10) {
                    mem[0][idx]++;
                    if (mem[0][idx] > 1) {
                        return false;
                    }
                }
                idx = board[col][row] - '0';
                if (idx > 0 && idx < 10) {
                    mem[1][idx]++;
                    if (mem[1][idx] > 1) {
                        return false;
                    }
                }
                count++;
                if (count == 9) {
                    mem = new int[2][10];
                    count = 0;
                }
            }
        }

        for (int rowCount = 0; rowCount < 3; rowCount++) {
            for (int colCount = 0; colCount < 3; colCount++) {
                for (int row = rowCount * 3; row < rowCount * 3 + 3; row++) {
                    for (int col = colCount * 3; col < colCount * 3 + 3; col++) {
                        int idx = board[row][col] - '0';
                        if (idx > 0 && idx < 10) {
                            mem[0][idx]++;
                            if (mem[0][idx] > 1) {
                                return false;
                            }
                        }
                        idx = board[col][row] - '0';
                        if (idx > 0 && idx < 10) {
                            mem[1][idx]++;
                            if (mem[1][idx] > 1) {
                                return false;
                            }
                        }
                        count++;
                        if (count == 9) {
                            mem = new int[2][10];
                            count = 0;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
        ));
    }
}
