package leetcode;

import java.util.*;

public class topic_2248 {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int[] num : nums){
            for (int number : num){
                int value = map.get(number) == null ? 0 : map.get(number);
                map.put(number, value + 1);
            }
        }

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers){
            Integer value = map.get(integer);
            if (value != null && value == nums.length){
                result.add(integer);
            }
        }
        result.sort(Comparator.comparingInt(n -> n));
        return result;
    }
}