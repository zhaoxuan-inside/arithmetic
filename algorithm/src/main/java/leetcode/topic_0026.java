package leetcode;

public class topic_0026 {
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        int last = 1;

        while (last < nums.length){
            if (nums[pre] == nums[last]){
                last++;
            } else {
                nums[pre + 1] = nums[last];
                pre++;
                last++;
            }
        }

        return pre + 1;

    }


}
