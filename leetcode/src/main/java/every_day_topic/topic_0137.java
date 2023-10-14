package every_day_topic;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_0137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                count = 0;
            }
            count++;
            if (count == 3) {
                map.remove(num);
            } else {
                map.put(num, count);
            }
        }

        return map.keySet().stream().findFirst().get();

    }

    public int faster(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
