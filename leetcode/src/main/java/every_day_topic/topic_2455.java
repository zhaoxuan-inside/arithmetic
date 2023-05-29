package every_day_topic;

@SuppressWarnings("unused")
public class topic_2455 {

    public static int averageValue(int[] nums) {

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }

        return sum == 0 ? 0 : sum / count;

    }

}
