package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0077 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > n) {
            return new ArrayList<>();
        }
        if (k == n) {
            List<Integer> curr = new ArrayList<>();
            for (int idx = 1; idx <= n; idx++) {
                curr.add(idx);
            }
            ans.add(curr);
        }
        if (k < n) {
            for (int idx = 1; idx <= n - k + 1; idx++) {
                List<Integer> curr = new ArrayList<>();
                curr.add(idx);
                ans.addAll(combine(curr, k, n));
            }
        }
        return ans;
    }

    private static List<List<Integer>> combine(List<Integer> subAns, int k, int n) {
        List<List<Integer>> currAns = new ArrayList<>();
        if (subAns.size() == k) {
            currAns.add(subAns);
            return currAns;
        }

        int size = subAns.size();
        int start = subAns.get(size - 1) + 1;

        for (int idx = start; idx <= n - k + size + 1; idx++) {
            List<Integer> currSubAns = new ArrayList<>(subAns);
            currSubAns.add(idx);
            currAns.addAll(combine(currSubAns, k, n));
        }
        return currAns;
    }

}
