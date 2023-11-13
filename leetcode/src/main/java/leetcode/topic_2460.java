package leetcode;

@SuppressWarnings("unused")
public class topic_2460 {

    public static int[] applyOperations(int[] nums) {

        for (int index = 0; index < nums.length - 1; index++) {

            if (nums[index] == nums[index + 1]) {
                nums[index] = nums[index + 1] * 2;
                nums[index + 1] = 0;
            }

        }

        int[] tailZero = new int[nums.length];

        int tailZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                tailZero[tailZeroIndex] = num;
                tailZeroIndex++;
            }
        }

        return tailZero;

    }

}
