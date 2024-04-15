package leetcode;

@SuppressWarnings("unused")
public class topic_0074 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int row = 0; row < matrix.length; row++) {
            if (row < matrix.length - 1) {
                if (matrix[row][0] <= target && matrix[row + 1][0] >= target) {
                    if (include(matrix[row], target)) {
                        return true;
                    }
                }
            } else {
                if (matrix[row][0] <= target && matrix[row][colLen - 1] >= target) {
                    if (include(matrix[row], target)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean include(int[] line, int target) {
        int start = 0;
        int end = line.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (line[mid] == target) {
                return true;
            }
            if (line[mid] > target) {
                end = mid - 1;
            }
            if (line[mid] < target) {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return false;
    }

    public static boolean better(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;

        int colLen = matrix[0].length;
        int rowLen = matrix.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            int rowIdx = mid / colLen;
            int colIdx = mid % colLen;

            if (matrix[rowIdx][colIdx] == target) {
                return true;
            } else if (matrix[rowIdx][colIdx] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(better(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 4));
        System.out.println(better(new int[][]{{1}}, 1));
    }
}
