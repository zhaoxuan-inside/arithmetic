package leetcode;

@SuppressWarnings("unused")
public class topic_0268 {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int ans = length * (length + 1) / 2;
        for (int num : nums) {
            ans -= num;
        }
        return ans;
    }
}
