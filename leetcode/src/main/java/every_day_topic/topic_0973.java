package every_day_topic;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class topic_0973 {

    private static class Location {
        long length;
        int x;
        int y;

        public Location(int x, int y) {
            this.length = (long) x * x + (long) y * y;
            this.x = x;
            this.y = y;
        }

    }

    public static int[][] kClosest(int[][] points, int k) {
        Map<Integer, int[][]> map = new HashMap<>();
        int minLength = -1;
        int locationCount = 0;

        List<Location> locations = new ArrayList<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            locations.add(new Location(x, y));

        }

        List<Location> sorted = locations.stream()
                .sorted((loc1, loc2) -> loc2.length > loc1.length ? -1 : 1)
                .collect(Collectors.toList()).subList(0, Math.min(points.length, k));

        int[][] ans = new int[k][2];
        int index = 0;
        for (Location location : sorted) {
            ans[index][0] = location.x;
            ans[index][1] = location.y;
            index++;
        }
        return ans;
    }

}
