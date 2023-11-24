package leetcode;

@SuppressWarnings("unused")
public class topic_0498 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[] ans = new int[rowLen * colLen];
        int ansIdx = 0;
        for (int idx = 0; idx < rowLen + colLen - 1; idx++) {
            if (idx % 2 == 1) {
                int rowIdx = idx < colLen ? 0 : idx - colLen + 1;
                int colIdx = idx < colLen ? idx : colLen - 1;
                while (rowIdx < rowLen && colIdx >= 0) {
                    ans[ansIdx] = mat[rowIdx][colIdx];
                    ansIdx++;
                    rowIdx++;
                    colIdx--;
                }
            } else {
                int rowIdx = idx < rowLen ? idx : rowLen - 1;
                int colIdx = idx < rowLen ? 0 : idx - rowLen + 1;
                while (rowIdx >= 0 && colIdx < colLen) {
                    ans[ansIdx] = mat[rowIdx][colIdx];
                    ansIdx++;
                    rowIdx--;
                    colIdx++;
                }
            }
        }
        return ans;
    }

}
