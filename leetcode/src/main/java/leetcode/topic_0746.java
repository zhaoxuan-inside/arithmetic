package leetcode;

@SuppressWarnings("unused")
public class topic_0746 {

    public static int minCostClimbingStairs(int[] cost) {

        int step = cost.length + 1;
        int[] mem = new int[step];

        for (int index = 2; index < step; index++) {
            mem[index] = Math.min(mem[index - 1] + cost[index - 1], mem[index - 2] + cost[index - 2]);
        }

        return mem[step - 1];

    }

}
