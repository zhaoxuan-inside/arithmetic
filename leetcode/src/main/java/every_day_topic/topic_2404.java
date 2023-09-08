package every_day_topic;

import java.util.HashMap;
import java.util.Map;

public class topic_2404 {
    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int element = -1;

        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                count = 1;
                map.put(num, count);
            } else {
                ++count;
                map.put(num, count);
            }

            if (num % 2 == 0) {
                if (count > max) {
                    max = count;
                    element = num;
                }
                if (count == max && element > num) {
                    element = num;
                }
            }
        }

        return element;

    }

    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[]{2, 10000, 10000, 10000, 2}));
    }
}
