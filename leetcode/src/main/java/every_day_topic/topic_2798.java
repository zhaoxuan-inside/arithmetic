package every_day_topic;

@SuppressWarnings("unused")
public class topic_2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;

        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }

        return count;

    }
}
