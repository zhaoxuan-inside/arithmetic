package leetcode;

@SuppressWarnings("unused")
public class topic_2275 {

    public static int largestCombination(int[] candidates) {

        int max = 0;

        int maxNum = 0;
        for (int candidate : candidates) {
            maxNum = Math.max(maxNum, candidate);
        }
        int bitCount = 32 - Integer.numberOfLeadingZeros(maxNum);

        for (int bit = 0; bit < bitCount; bit++) {
            max = Math.max(largestBitCombination(candidates, bit), max);
        }

        return max;

    }

    private static int largestBitCombination(int[] candidates, int bit) {

        int max = 0;

        for (int candidate : candidates) {
            max += candidate >> bit & 1;
        }

        return max;

    }

}
