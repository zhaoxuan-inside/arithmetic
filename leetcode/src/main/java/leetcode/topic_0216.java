package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);
        dfs(9, n, k, ans, path);
        return ans;
    }

    private void dfs(int end, int t, int count, List<List<Integer>> ans, List<Integer> path) {
        int remain = count - path.size();
        if (t < 0 || t > (end * 2 - remain + 1) * remain / 2) {
            return;
        }
        if (remain == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int num = end; num >= remain; num--) {
            path.add(num);
            dfs(num - 1, t - num, count, ans, path);
            path.remove(path.size() - 1);
        }
    }

}
