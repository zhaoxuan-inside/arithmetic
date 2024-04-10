package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0046 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            int currAnsSize = ans.size();
            for (int idx = 0; idx < currAnsSize; idx++) {
                List<Integer> curr = ans.get(idx);
                for (int currIdx = 0; currIdx < curr.size(); currIdx++) {
                    List<Integer> newCurr = new ArrayList<>(curr);
                    newCurr.add(currIdx, num);
                    ans.add(newCurr);
                }
                curr.add(num);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
