package leetcode;

@SuppressWarnings("unused")
public class topic_0079 {

    public static boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == word.charAt(0)) {
                    char ch = board[row][col];
                    board[row][col] = '#';
                    boolean match = match(board, word, row, col, 1);
                    board[row][col] = ch;
                    if (match) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean match(char[][] board, String word, int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (row > 0 && board[row - 1][col] == word.charAt(idx) && board[row - 1][col] != '#') {
            char ch = board[row - 1][col];
            board[row - 1][col] = '#';
            boolean result = match(board, word, row - 1, col, idx + 1);
            board[row - 1][col] = ch;
            if (result) {
                return true;
            }
        }
        if (row < board.length - 1 && board[row + 1][col] == word.charAt(idx) && board[row + 1][col] != '#') {
            char ch = board[row + 1][col];
            board[row + 1][col] = '#';
            boolean result = match(board, word, row + 1, col, idx + 1);
            board[row + 1][col] = ch;
            if (result) {
                return true;
            }
        }
        if (col > 0 && board[row][col - 1] == word.charAt(idx) && board[row][col - 1] != '#') {
            char ch = board[row][col - 1];
            board[row][col - 1] = '#';
            boolean result = match(board, word, row, col - 1, idx + 1);
            board[row][col - 1] = ch;
            if (result) {
                return true;
            }
        }
        if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(idx) && board[row][col + 1] != '#') {
            char ch = board[row][col + 1];
            board[row][col + 1] = '#';
            boolean result = match(board, word, row, col + 1, idx + 1);
            board[row][col + 1] = ch;
            if (result) {
                return true;
            }
        }
        return false;
    }
}
