package every_day_topic;

@SuppressWarnings("unused")
public class topic_2560 {

    public int minCapability(int[] nums, int k) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        int midNum = (maxNum + minNum) / 2;
        while (minNum < maxNum) {
            int robCount = 0;
            boolean lastUsed = false;
            for (int num : nums) {
                if (num < midNum && !lastUsed) {
                    lastUsed = true;
                    robCount++;
                } else {
                    lastUsed = false;
                }
            }
            if (robCount > k) {
                maxNum = midNum - 1;
            } else {
                minNum = midNum + 1;
            }
            midNum = (minNum + maxNum) / 2;
        }

        return minNum;

    }

}
