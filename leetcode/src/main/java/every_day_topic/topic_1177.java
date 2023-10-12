package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_1177 {

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        char[] charArray = s.toCharArray();
        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {

            if (ifPalindrome(charArray, query[0], query[1]) > query[2]) {
                result.add(false);
            } else {
                result.add(true);
            }

        }

        return result;

    }

    private static int ifPalindrome(char[] chars, int begin, int end) {

        Map<Character, Boolean> map = new HashMap<>();
        for (int i = begin; i <= end; i++) {
            if (map.get(chars[i]) == null) {
                map.put(chars[i], true);
            } else {
                map.remove(chars[i]);
            }
        }

        return map.size() / 2;

    }

}