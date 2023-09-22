package every_day_topic;

@SuppressWarnings("unused")
public class topic_2535 {
    public static int differenceOfSum(int[] nums) {

        int sum = 0;
        int bitSum = 0;

        for (int num : nums) {
            int tmp = num;
            while (tmp > 0) {
                bitSum += tmp % 10;
                tmp /= 10;
            }
            sum += num;
        }

        return Math.abs(sum - bitSum);
    }

}
