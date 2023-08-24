package every_day_topic;

import java.util.*;

public class topic_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int abs = arr[i + 1] - arr[i];
            List<Integer> tmp = new ArrayList<>();
            tmp.add(arr[i]);
            tmp.add(arr[i + 1]);

            if (abs < min) {
                result.clear();
                result.add(tmp);
                min = abs;
                continue;
            }

            if (abs == min) {
                result.add(tmp);
            }

        }

        return result;
    }
}
