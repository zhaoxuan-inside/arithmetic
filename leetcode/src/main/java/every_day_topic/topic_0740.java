package every_day_topic;

public class topic_0740 {

    public static int deleteAndEarn(int[] nums) {
        int maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }

        int[] map = new int[maxNum + 1];
        for (int num : nums) {
            map[num] += num;
        }

        int max = 0;
        for (int index = 0; index < maxNum + 1; index++) {
            map[index] = Math.max(index - 2 >= 0 ? map[index - 2] : 0, index - 3 >= 0 ? map[index - 3] : 0) + map[index];
            max = Math.max(max, map[index]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
    }

}