package every_day_topic;

@SuppressWarnings("unused")
public class topic_2520 {
    public int countDigits(int num) {
        int[] divides = new int[10];
        int divideIndex = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            divides[divideIndex++] = tmpNum % 10;
            tmpNum /= 10;
        }

        int ans = 0;
        for (int index = 0; index < divideIndex; index++) {
            if (num % divides[index] == 0) {
                ans++;
            }
        }
        return ans;
    }
}
