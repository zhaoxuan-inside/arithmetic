package every_day_topic;

import java.util.*;

public class topic_0207 {

    private static int[] mem;
    private static final Map<Integer, List<Integer>> TOPOLOGY = new HashMap<>();

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        mem = new int[numCourses];

        if (prerequisites.length == 0) {
            return true;
        }

        for (int[] prerequisite : prerequisites) {
            List<Integer> deps = TOPOLOGY.get(prerequisite[0]);
            if (deps == null) {
                deps = new ArrayList<>();
            }
            deps.add(prerequisite[1]);
            TOPOLOGY.put(prerequisite[0], deps);

            mem[prerequisite[1]] = 1;

        }

        int courses = 0;
        for (int index = 0; index < numCourses; index++) {
            if (mem[index] == 1) {
                continue;
            }

            courses += dfs(index);

            if (courses >= numCourses) {
                return true;
            }

        }

        return false;
    }

    private static int dfs(int index) {

        int curr = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            mem[pop] = 2;
            curr++;
            List<Integer> pre = TOPOLOGY.get(pop);
            if (pre == null) {
                continue;
            }
            for (Integer integer : pre) {
                if (integer != 2) {
                    stack.push(integer);
                }
            }
        }

        return curr;

    }

}