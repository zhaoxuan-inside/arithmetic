package interview;

@SuppressWarnings("unused")
public class interview_16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] ans = new int[k + 1];
        for (int idx = 0; idx <= k; idx++) {
            ans[idx] = longer * idx + shorter * (k - idx);
        }
        return ans;
    }
}
