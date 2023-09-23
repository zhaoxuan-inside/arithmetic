package every_day_topic;

@SuppressWarnings("unused")
public class topic_2437 {

    public static int countTime(String time) {
        int ans = 1;
        switch (time.charAt(0)) {
            case '0':
            case '1':
                if (time.charAt(1) == '?') {
                    ans *= 10;
                }
                break;
            case '2':
                if (time.charAt(1) == '?') {
                    if (time.charAt(0) > '1') {
                        ans *= 4;
                    } else {
                        ans *= 10;
                    }
                }
                break;
            case '?':
                if (time.charAt(1) == '?') {
                    ans *= 24;
                } else {
                    if (time.charAt(1) > 4) {
                        ans *= 2;
                    } else {
                        ans *= 3;
                    }
                }
        }

        if (time.charAt(3) == '?') {
            ans *= 6;
        }

        if (time.charAt(4) == '?') {
            ans *= 10;
        }

        return ans;
    }
}
