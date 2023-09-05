package every_day_topic;

public class topic_1572 {
    public int diagonalSum(int[][] mat) {
        int result = 0;

        for (int i = 0; i < mat.length; i++) {
            result += mat[i][i];
            result += mat[i][mat.length - i - 1];
        }

        if (mat.length % 2 == 1) {
            result -= mat[mat.length / 2][mat.length / 2];
        }

        return result;
    }
}
