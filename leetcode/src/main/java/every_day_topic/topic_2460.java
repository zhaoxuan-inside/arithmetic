package every_day_topic;

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

    public static void main(String[] args) {
        for (int i : applyOperations(new int[]{847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272})) {
            System.out.println(i);
        }
    }

}
