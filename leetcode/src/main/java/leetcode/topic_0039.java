package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0039 {
    private static final int MIN = 150;
    private static List<List<Integer>> ans;
    private static int[] sortedCandidates;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        sortedCandidates = candidates;
        int len = candidates.length;
        dfs(new ArrayList<>(), len - 1, target);
        return ans;
    }

    public static void dfs(List<Integer> subAns, int end, int remain) {
        if (end < 0 || ans.size() >= MIN) {
            return;
        }
        if (remain < sortedCandidates[end]) {
            dfs(subAns, end - 1, remain);
            return;
        }

        if (remain == 0) {
            ans.add(subAns);
            return;
        }
        int div = remain / sortedCandidates[end];
        for (int idx = div; idx >= 0; idx--) {
            List<Integer> currSubAns = new ArrayList<>(subAns);
            for (int count = 0; count < idx; count++) {
                currSubAns.add(sortedCandidates[end]);
            }
            int nextRemain = remain - sortedCandidates[end] * idx;
            if (nextRemain == 0) {
                ans.add(currSubAns);
                continue;
            }
            dfs(currSubAns, end - 1, nextRemain);
        }
    }

}
