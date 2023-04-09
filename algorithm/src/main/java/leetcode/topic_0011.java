package leetcode;

public class topic_0011 {
    public int maxArea(int[] height) {
        int res = 0;

        int pre = 0;
        int last = height.length - 1;

        while (pre < last) {

            int area = (last - pre) * Math.min(height[pre], height[last]);
            res = Math.max(res, area);

            if (height[pre] < height[last]) {
                pre++;
            } else {
                last--;
            }

        }
        return res;
    }
}
