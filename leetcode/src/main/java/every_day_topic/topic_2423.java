package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_2423 {
    public boolean equalFrequency(String word) {
        Map<Byte, Integer> map = new HashMap<>();
        byte[] bytes = word.getBytes();

        for (byte ch : bytes) {
            Integer count = map.get(ch);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(ch, count);
        }

        for (Byte key : map.keySet()) {
            Map<Byte, Integer> copy = new HashMap<>(map);
            Integer integer = copy.get(key);
            if (integer > 1) {
                copy.put(key, integer - 1);
            } else {
                copy.remove(key);
            }
            Set<Integer> set = new HashSet<>(copy.values());
            if (set.size() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean batter(String word) {
        int[] statistic = new int[26];
        for (char c : word.toCharArray()) {
            statistic[c - 'a']++;
        }

        for (char removeCh : word.toCharArray()) {
            statistic[removeCh - 'a']--;
            boolean flag = true;
            int firstCount = 0;
            for (int count : statistic) {
                if (count != 0) {
                    firstCount = count;
                    break;
                }
            }
            for (int count : statistic) {
                if (count != 0 && count != firstCount) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            statistic[removeCh - 'a']++;
        }
        return false;
    }
}
