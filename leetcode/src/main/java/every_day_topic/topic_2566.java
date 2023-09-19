package every_day_topic;

@SuppressWarnings("unused")
public class topic_2566 {
    public static int minMaxDifference(int num) {
        String numStr = String.valueOf(num);

        int min = Integer.parseInt(numStr.replace(numStr.charAt(0), '0'));
        int max = num;

        for (int index = 0; index < numStr.length(); index++) {
            if (numStr.charAt(index) != '9') {
                max = Integer.parseInt(numStr.replace(numStr.charAt(index), '9'));
                break;
            }
        }

        return max - min;

    }

}
