package every_day_topic;

@SuppressWarnings("unused")
public class topic_2582 {
    public int passThePillow(int n, int time) {
        int direction = -1;

        int index = 1;
        while (time > 0) {
            if (index == 1 || index == n) {
                direction *= -1;
            }
            index += direction;
            time--;
        }

        return index;
    }
}
