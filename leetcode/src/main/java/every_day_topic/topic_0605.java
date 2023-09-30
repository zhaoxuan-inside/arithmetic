package every_day_topic;

@SuppressWarnings("unused")
public class topic_0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int index = 0; index < flowerbed.length; index++) {
            if (flowerbed[index] == 1) {
                continue;
            }

            int pre = index - 1;
            int last = index + 1;

            if (pre >= 0 && flowerbed[pre] == 1) {
                continue;
            }

            if (last < flowerbed.length && flowerbed[last] == 1) {
                continue;
            }

            n--;
            flowerbed[index] = 1;

        }

        return n <= 0;
    }
}
