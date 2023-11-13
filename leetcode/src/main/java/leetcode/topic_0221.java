package leetcode;

@SuppressWarnings("unused")
public class topic_0221 {
    public static int maximalSquare(char[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int max = 0;

        int[][] mem = new int[rowLen][colLen];

        for (int index = 0; index < rowLen; index++) {
            if (matrix[index][0] == '1') {
                mem[index][0] = 1;
                max = 1;
            }
        }

        for (int index = 0; index < colLen; index++) {
            if (matrix[0][index] == '1') {
                mem[0][index] = 1;
                max = 1;
            }
        }

        for (int rowIndex = 1; rowIndex < rowLen; rowIndex++) {
            for (int colIndex = 1; colIndex < colLen; colIndex++) {
                if (matrix[rowIndex][colIndex] == '0') {
                    continue;
                }

                if (matrix[rowIndex - 1][colIndex - 1] == '0') {
                    mem[rowIndex][colIndex] = 1;
                    max = Math.max(mem[rowIndex][colIndex], max);
                    continue;
                }

                int edgeCount = mem[rowIndex - 1][colIndex - 1] + 1;
                boolean flag = true;
                for (int index = 1; index < edgeCount; index++) {
                    if (matrix[rowIndex][colIndex - index] == '0' || matrix[rowIndex - index][colIndex] == '0') {
                        flag = false;
                        edgeCount = index;
                        break;
                    }
                }
                if (flag) {
                    mem[rowIndex][colIndex] = mem[rowIndex - 1][colIndex - 1] + 1;
                } else {
                    mem[rowIndex][colIndex] = edgeCount;
                }
                max = Math.max(mem[rowIndex][colIndex], max);
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}}));
    }
}
