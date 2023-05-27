package every_day_topic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class topic_0970 {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        Set<Integer> result = new HashSet<>();

        for (int lastMin = 1; lastMin < bound; lastMin *= min) {
            for (int lastMax = 1; lastMax + lastMin <= bound; lastMax *= max) {
               if ((lastMax + lastMin) < bound) {
                   result.add(lastMax + lastMin);
               }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        powerfulIntegers(3, 5, 15).forEach(System.out::println);
    }
}
