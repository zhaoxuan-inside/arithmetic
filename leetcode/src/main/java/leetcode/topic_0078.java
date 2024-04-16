package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0078 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        subsets(ans, nums, 0, nums.length);
        return ans;
    }

    private static List<List<Integer>> subsets(List<List<Integer>> indexs, int[] nums, int curr, int len) {
        if (curr >= len) {
            return indexs;
        }

        List<List<Integer>> subAns = new ArrayList<>();
        for (List<Integer> index : indexs) {
            List<Integer> subAns0 = new ArrayList<>(index);
            subAns0.add(nums[curr]);
            subAns.add(subAns0);
        }
        indexs.addAll(subAns);
        return subsets(indexs, nums, curr + 1, len);
    }

}
