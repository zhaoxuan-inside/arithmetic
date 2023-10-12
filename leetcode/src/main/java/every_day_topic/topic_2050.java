package every_day_topic;

import java.util.*;

public class topic_2050 {

    public static int minimumTime(int n, int[][] relations, int[] time) {

        if (relations.length == 0) {
            int max = time[0];
            for (int i : time) {
                max = Math.max(max, i);
            }

            return max;
        }

        int result = 0;

        int end = findEndPoint(n, relations);

        Stack<Integer> layout = new Stack<>();
        layout.push(end);
        while (!layout.isEmpty()) {

            List<Integer> curr = new ArrayList<>(layout);
            layout.clear();

            int subMax = Integer.MIN_VALUE;

            for (int[] relation : relations) {
                if (curr.contains(relation[1])) {
                    layout.add(relation[0]);
                    subMax = Math.max(subMax, time[relation[0] - 1]);
                }
            }

            if (subMax == Integer.MIN_VALUE) {
                break;
            }

            result += subMax;

        }

        return result + time[end - 1];

    }

    private static int findEndPoint(int total, int[][] relations) {

        Set<Integer> pres = new HashSet<>();
        Set<Integer> nexts = new HashSet<>();

        for (int[] relation : relations) {
            pres.add(relation[0]);
            nexts.add(relation[1]);
        }

        nexts.removeAll(pres);

        return nexts.stream().findFirst().get();

    }

}
