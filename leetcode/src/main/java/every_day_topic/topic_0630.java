package every_day_topic;

import java.util.*;

public class topic_0630 {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));

        Queue<Integer> sortedDurations = new PriorityQueue<>((course1, course2) -> course2 - course1);

        int currEnd = 0;
        for (int[] course : courses) {
            if (currEnd + course[0] <= course[1]) {
                currEnd += course[0];
                sortedDurations.offer(course[0]);
            } else {
                if (!sortedDurations.isEmpty()) {
                    Integer duration = sortedDurations.peek();
                    if (duration > course[0]) {
                        sortedDurations.poll();
                        sortedDurations.offer(course[0]);
                        currEnd -= duration;
                        currEnd += course[0];
                    }
                }
            }
        }

        return sortedDurations.size();

    }

    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][]{{1, 2}, {2, 3}}));
        System.out.println(batter(new int[][]{{1, 2}, {2, 3}}));
    }


    public static int batter(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }

}
