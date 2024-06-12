package leetcode;

@SuppressWarnings("unused")
public class topic_3168 {
    public int minimumChairs(String s) {
        int max = Integer.MIN_VALUE;
        int currCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'E') {
                currCount++;
                max = Math.max(max, currCount);
                continue;
            }
            if (ch == 'L') {
                if (currCount > 0) {
                    currCount--;
                }
            }
        }
        return max;
    }
}
