package leetcode;

import java.util.*;

public class topic_2418 {
    public String[] sortPeople(String[] names, int[] heights) {

        Map<Integer, String> map = new HashMap<>();

        for (int index = 0; index < names.length; index++) {
            map.put(heights[index], names[index]);
        }

        Arrays.sort(heights);

        String[] result = new String[names.length];
        for (int index = 0; index < names.length; index++) {
            result[index] = map.get(heights[names.length - index]);
        }

        return result;

    }
}
