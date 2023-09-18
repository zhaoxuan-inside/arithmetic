package every_day_topic;

@SuppressWarnings("unused")
public class topic_0374 {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid = (n + 1) / 2;

        while (start <= end) {
            int guess = guess(mid);
            switch (guess) {
                case -1:
                    end = mid - 1;
                    mid = start / 2 + end / 2 + (start % 2 == 1 && end % 2 == 1 ? 1 : 0);
                    break;
                case 0:
                    return mid;
                case 1:
                    start = mid + 1;
                    mid = start / 2 + end / 2 + (start % 2 == 1 && end % 2 == 1 ? 1 : 0);
                    break;
            }
        }
        return 0;
    }

    private int guess(int num) {
        return 0;
    }
}
