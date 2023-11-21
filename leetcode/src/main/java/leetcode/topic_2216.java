package leetcode;

@SuppressWarnings("unused")
public class topic_2216 {
    public static int minDeletion(int[] nums) {
        int ans = 0;
        for (int idx = 0; idx < nums.length; ) {
            if (idx + 1 < nums.length) {
                int next = idx + 1;
                while (nums[next] == nums[idx]) {
                    next++;
                    ans++;
                    if (next >= nums.length) {
                        ans++;
                        return ans;
                    }
                }
                idx = next + 1;
            } else {
                idx++;
                ans++;
            }
        }
        return ans;
    }

}
