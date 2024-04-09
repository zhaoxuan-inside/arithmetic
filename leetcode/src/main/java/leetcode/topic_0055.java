package leetcode;

@SuppressWarnings("unused")
public class topic_0055 {
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int idx = 0; idx < nums.length; idx++) {
            int bigNextIdx = nums[idx] + idx;
            int next = idx;
            for (int currIdx = idx; currIdx <= bigNextIdx && currIdx < nums.length; currIdx++) {
                int currBigNextIds = nums[currIdx] + currIdx;
                if (currBigNextIds > bigNextIdx) {
                    bigNextIdx = currBigNextIds;
                    next = currIdx;
                }
            }
            if (bigNextIdx >= nums.length - 1) {
                return true;
            }
            if (bigNextIdx <= nums[idx] + idx) {
                return false;
            }
            idx = next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
