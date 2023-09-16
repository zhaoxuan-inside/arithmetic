package every_day_topic;

@SuppressWarnings("unused")
public class topic_0860 {
    public static boolean lemonadeChange(int[] bills) {
        int[] remains = new int[5];
        for (int bill : bills) {
            switch (bill - 5) {
                case 5:
                    if (remains[1] > 0) {
                        remains[1]--;
                    } else {
                        return false;
                    }
                    break;
                case 15:
                    if (remains[2] > 0 && remains[1] > 0) {
                        remains[2]--;
                        remains[1]--;
                    } else if (remains[1] > 2) {
                        remains[1] -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
            remains[bill / 5]++;
        }

        return true;

    }

}
