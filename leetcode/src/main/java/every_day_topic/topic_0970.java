package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
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

}
