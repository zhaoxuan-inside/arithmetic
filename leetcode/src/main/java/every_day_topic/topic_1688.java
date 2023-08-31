package every_day_topic;

public class topic_1688 {
    public static int numberOfMatches(int n) {

        int result = 0;

        while (n > 1) {

            int half = n / 2;

            if (n % 2 == 1) {
                n = half + 1;
            } else {
                n = half;
            }

            result += half;
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(numberOfMatches(14));
    }

}
