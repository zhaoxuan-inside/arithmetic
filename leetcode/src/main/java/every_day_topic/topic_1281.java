package every_day_topic;

@SuppressWarnings("unused")
public class topic_1281 {
    public static int subtractProductAndSum(int n) {

        long sum = 0;
        long multi = 1;

        String string = String.valueOf(n);
        for (int index = 0; index < string.length(); index++) {
            long num = Long.parseLong(String.valueOf(string.charAt(index)));

            multi *= num;
            sum += num;

        }

        return (int) (multi - sum);

    }

}
