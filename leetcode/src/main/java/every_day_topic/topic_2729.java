package every_day_topic;

@SuppressWarnings("unused")
public class topic_2729 {
    public static boolean isFascinating(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n)
                .append(2 * n)
                .append(3 * n);
        int length = stringBuilder.length();
        if (stringBuilder.length() != 9 || stringBuilder.toString().contains("0")) {
            return false;
        }

        String str = stringBuilder.toString();
        for (int index = 1; index < 10; index++) {
            if (!str.contains(String.valueOf(index))) {
                return false;
            }
        }

        return true;

    }

    int[] count = new int[10];

    public boolean faster(int n) {
        return f(n) && f(n * 2) && f(n * 3);
    }

    boolean f(int n) {
        return n < 1000
                && ++count[n % 10] < 2
                && ++count[n / 10 % 10] < 2
                && ++count[n / 100 % 10] < 2
                && count[0] == 0;
    }

}
