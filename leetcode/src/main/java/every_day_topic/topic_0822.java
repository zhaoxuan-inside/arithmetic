package every_day_topic;

import java.util.*;
import java.util.stream.Collectors;

public class topic_0822 {
    public int flipgame(int[] fronts, int[] backs) {
        while (true) {
            Map<Integer, List<Integer>> mapFronts = mapArray(fronts);
            Map<Integer, List<Integer>> mapBacks = mapArray(backs);

            Set<Integer> mapKeys = mapFronts.keySet();
            Set<Integer> backKeys = mapBacks.keySet();

            mapKeys.removeAll(backKeys);
            if (mapKeys.size() > 0) {
                return mapBacks.get(mapKeys.stream().sorted().collect(Collectors.toList()).get(0)).get(0);
            }
        }
    }

    private Map<Integer, List<Integer>> mapArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {

            List<Integer> values = map.get(nums[index]);
            if (null == values) {
                values = new ArrayList<>();
                map.put(nums[index], values);
            }
            values.add(index);
        }
        return map;
    }
}
