package leetcode;

@SuppressWarnings("unused")
public class topic_0219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end < nums.length && end <= start + k; end++) {
                if (nums[start] == nums[end]) {
                    return true;
                }
            }
        }
        return false;
    }
}
