package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] base = nums1.length > nums2.length ? nums2 : nums1;
        int[] scan = nums1.length > nums2.length ? nums1 : nums2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : base) {
            Integer count = map.get(i);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(i, count);
        }

        int[] result = new int[base.length];
        int index = 0;
        for (int i : scan) {
            Integer integer = map.get(i);
            if (integer != null && integer > 0) {
                integer--;
                map.put(i, integer);
                result[index++] = i;
            }
        }

        return Arrays.copyOfRange(result, 0, index);

    }
}
