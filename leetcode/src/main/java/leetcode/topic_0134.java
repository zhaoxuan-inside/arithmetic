package leetcode;

@SuppressWarnings("unused")
public class topic_0134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] mem = new int[len];

        int minRemainGas = Integer.MAX_VALUE;
        int minRemainGadIdx = 0;
        for (int idx = 1; idx < len; idx++) {
            mem[idx] = mem[idx - 1] + gas[idx - 1] - cost[idx - 1];
            if (mem[idx] < minRemainGas) {
                minRemainGas = mem[idx];
                minRemainGadIdx = idx;
            }
        }

        mem[0] = gas[len - 1] + mem[len - 1] - cost[len - 1];

        if (mem[0] < 0) {
            return -1;
        }

        if (mem[0] <= minRemainGas) {
            minRemainGadIdx = 0;
        }

        return minRemainGadIdx;
    }

}
