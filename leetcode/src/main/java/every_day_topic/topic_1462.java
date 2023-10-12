package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_1462 {
    private static Map<Integer, List<Integer>> PRE_RELATION;

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Boolean> result = new ArrayList<>();
        PRE_RELATION = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[1];
            int preCourse = prerequisite[0];

            List<Integer> preCourses = PRE_RELATION.get(course);
            List<Integer> prePreCourses = PRE_RELATION.get(preCourse);
            if (prePreCourses != null && prePreCourses.contains(course)) {
                prePreCourses.remove(course);
                continue;
            }
            if (preCourses == null) {
                preCourses = new ArrayList<>();
            }
            preCourses.add(preCourse);
            PRE_RELATION.put(course, preCourses);
        }

        for (int[] query : queries) {
            result.add(checkIsPreCourse(query[1], query[0]));
        }

        return result;

    }

    private static boolean checkIsPreCourse(int course, int preCourse) {

        List<Integer> preCourses = PRE_RELATION.get(course);
        if (preCourses == null || preCourses.isEmpty()) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> preCouresesFirst = PRE_RELATION.get(course);
        if (preCouresesFirst != null) {
            stack.addAll(preCouresesFirst);
        }

        while (!stack.isEmpty()) {
            if (stack.contains(preCourse)) {
                return true;
            }
            Stack<Integer> tmpStack = new Stack<>();
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                List<Integer> preCoursesByPop = PRE_RELATION.get(pop);
                if (preCoursesByPop != null && !preCoursesByPop.isEmpty()) {
                    tmpStack.addAll(preCoursesByPop);
                }
            }
            stack.addAll(tmpStack);
            tmpStack.clear();
        }

        return false;

    }

    public List<Boolean> batter(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] preCoursesMap = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preCoursesMap[i] = new ArrayList<>();
        }
        int[] indgree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            ++indgree[p[1]];
            preCoursesMap[p[0]].add(p[1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int preCourse : preCoursesMap[cur]) {
                isPre[cur][preCourse] = true;
                for (int course = 0; course < numCourses; ++course) {
                    isPre[course][preCourse] = isPre[course][preCourse] | isPre[course][cur];
                }
                --indgree[preCourse];
                if (indgree[preCourse] == 0) {
                    queue.offer(preCourse);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

}
