package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_0090 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> empty = new ArrayList<>();
        ans.add(empty);
        for (int num : nums) {
            Set<List<Integer>> currAns = new HashSet<>();
            for (List<Integer> subAns : ans) {
                List<Integer> subList = new ArrayList<>(subAns);
                subList.add(num);
                currAns.add(subList);
            }
            ans.addAll(currAns);
        }
        return new ArrayList<>(ans);
    }
}
