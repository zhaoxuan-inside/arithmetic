package leetcode;

@SuppressWarnings("unused")
public class topic_1185 {
    private final static String[] WEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private final static int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

    public String dayOfTheWeek(int day, int month, int year) {
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; ++i) {
            days += MONTH_DAYS[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        days += day;
        return WEEK[(days + 3) % 7];
    }
}
