package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class topic_2637 {
    public int arithmeticTriplets(int[] nums, int diff) {

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        int index = 0;
        for (int num : nums){
            map.put(num, index);
            index++;
        }

        Set<Integer> integers = map.keySet();
        for (int num : integers){
            Integer i = map.get(num);
            Integer j = map.get(num + diff);
            Integer k = map.get(num + diff + diff);

            if (i != null && j != null && k != null) {
                result++;
            }
        }

        return result;
    }
}
