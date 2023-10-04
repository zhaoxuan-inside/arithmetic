package every_day_topic;

@SuppressWarnings("unused")
public class topic_0080 {
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        int last = 0;
        int ans = nums.length;

        while (pre < ans) {
            if (nums[pre] == nums[last]) {
                pre++;
                continue;
            }
            if (pre - last > 2) {
                move(nums, last + 2, pre, ans);
                ans -= pre - last - 2;
                pre -= pre - last - 1;
            }
            last = pre;
        }
        if (pre - last > 2) {
            ans -= pre - last - 2;
        }
        return ans;
    }

    private void move(int[] nums, int last, int pre, int length) {
        while (pre < length) {
            nums[last++] = nums[pre++];
        }
    }

    public int faster(int[] nums) {
        int replaceStart = 0;
        for (int index = 0; index < nums.length; index++) {
            if (replaceStart < 2 || nums[index] != nums[replaceStart - 2]) {
                nums[replaceStart] = nums[index];
                replaceStart += 1;
            }
        }
        return replaceStart;
    }
}
