package leetcode;

@SuppressWarnings("unused")
public class topic_0198 {
    public static int rob(int[] nums) {
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        int max = mem[0];

        for (int index = 1; index < nums.length; index++) {
            mem[index] = nums[index] + Math.max(index - 2 >= 0 ? mem[index - 2] : 0, index - 3 >= 0 ? mem[index - 3] : 0);
            max = Math.max(max, mem[index]);
        }

        return max;

    }

}
