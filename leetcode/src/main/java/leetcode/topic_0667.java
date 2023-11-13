package leetcode;

@SuppressWarnings("unused")
public class topic_0667 {

    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        // n - k - 1 个元素差为1；
        for (int index = 1; index < n - k; ++index) {
            answer[idx] = index;
            ++idx;
        }
        // k + 1个元素差不为1且互不相等，得到k个相差不等的差值；
        for (int index = n - k, end = n; index <= end; ++index, --end) {
            answer[idx] = index;
            ++idx;
            if (index != end) {
                answer[idx] = end;
                ++idx;
            }
        }
        return answer;
    }

}
