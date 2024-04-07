package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class topic_0040 {

    private static Set<List<Integer>> ans;
    private static int[] sortedCandidates;
    private static boolean ifEnd;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        long start = System.currentTimeMillis();
        ans = new HashSet<>();
        ifEnd = false;
        Arrays.sort(candidates);
        sortedCandidates = candidates;
        dfs(new ArrayList<>(), candidates.length - 1, target);
        System.out.println((System.currentTimeMillis() - start));
        return new ArrayList<>(ans);
    }

    public static void dfs(List<Integer> subAns, int end, int target) {
        if (ifEnd) {
            return;
        }
        if (target == 0) {
            subAns = subAns.stream().sorted().collect(Collectors.toList());
            ans.add(subAns);
            return;
        }
        if (end < 0 || target < 0) {
            return;
        }

        List<Integer> curr = new ArrayList<>(subAns);
        curr.add(sortedCandidates[end]);
        int nextEnd = end - 1;
        int nextTarget = target - sortedCandidates[end];
        dfs(new ArrayList<>(subAns), nextEnd, target);
        dfs(curr, nextEnd, nextTarget);
    }

}
