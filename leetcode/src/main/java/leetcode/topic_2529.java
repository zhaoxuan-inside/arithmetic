package leetcode;

@SuppressWarnings("unused")
public class topic_2529 {
    public int maximumCount(int[] nums) {
        int max = 0;

        int negative = 0;
        int positive = 0;

        for (int num : nums) {
            if (num > 0) {
                positive++;
                continue;
            }
            if (num < 0) {
                negative++;
            }
        }

        return Math.max(positive, negative);
    }
}
