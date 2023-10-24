package every_day_topic;

@SuppressWarnings("unused")
public class topic_1155 {
    static final int MOD = 1000000007;

    public int calculate(int n, int k, int target) {
        int[][] mem = new int[n + 1][target + 1];
        mem[0][0] = 0;

        for (int index = 1; index < n + 1; index++) {
            for (int targetIndex = 1; targetIndex < target + 1; targetIndex++) {
                int nextCount = mem[index - 1][targetIndex];
                for (int kIndex = 1; kIndex < k + 1; kIndex++) {
                    int currTarget = (targetIndex + kIndex) % MOD;
                    mem[index][currTarget] = ++mem[index][currTarget];
                }
            }
        }

        return mem[n][target];
    }


    public int numRollsToTarget(int n, int k, int target) {
        int[][] mem = new int[n + 1][target + 1];
        mem[0][0] = 1;
        for (int diceIndex = 1; diceIndex <= n; ++diceIndex) {
            for (int accumulateCount = 0; accumulateCount <= target; ++accumulateCount) {
                for (int currDiceCount = 1; currDiceCount <= k; ++currDiceCount) {
                    if (accumulateCount - currDiceCount >= 0) { // 累加，单调不减
                        mem[diceIndex][accumulateCount] = (mem[diceIndex][accumulateCount] +
                                mem[diceIndex - 1][accumulateCount - currDiceCount])
                                % MOD;
                    }
                }
            }
        }
        return mem[n][target];
    }
}
