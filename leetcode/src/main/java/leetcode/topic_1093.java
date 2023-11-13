package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class topic_1093 {

    public static double[] sampleStats(int[] count) {

        Map<Integer, Integer> map = new HashMap<>();

        double sum = 0;
        int total = 0;
        for (int index = 0; index < count.length; index++) {

            int size = count[index];
            sum += (double) index * size;

            if (size > 0) {
                map.put(index, size);
                total += size;
            }

        }

        SortedSet<Integer> keys = new TreeSet<>(map.keySet());

        int min = keys.first();
        int max = keys.last();
        double mean = sum / total;

        int maxSize = 0;
        int mode = 0;
        int scanSize = 0;
        boolean isOdd = total % 2 == 1;
        double median = -1;
        int lashMedian = 0;
        int half = total / 2;

        for (Integer key : keys) {

            Integer size = map.get(key);
            if (size > maxSize) {
                mode = key;
                maxSize = size;
            }

            scanSize += size;
            if (isOdd) {
                if (median == -1 && scanSize > half) {
                    median = key;
                }
            } else {
                if (median == -1 && scanSize == half) {
                    lashMedian = key;
                }

                if (median == -1 && scanSize > half) {
                    if (lashMedian == 0) {
                        median = key;
                    } else {
                        median = (lashMedian + key) / 2.0;
                    }
                }
            }

        }

        return new double[]{min, max, mean, median, mode};
    }

}
