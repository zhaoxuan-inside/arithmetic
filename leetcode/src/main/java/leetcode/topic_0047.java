package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0047 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
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
        return new ArrayList<>(new HashSet<>(ans));
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> better(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        iterator(nums, ans, 0);
        return ans;
    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public void iterator(int[] nums, List<List<Integer>> ans, int currIdx) {
        if (currIdx == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            ans.add(tmp);
            return;
        }

        for (int idx = currIdx; idx < nums.length; idx++) {
            boolean flag = false;
            for (int startIdx = currIdx; startIdx < idx; startIdx++) {
                if (nums[startIdx] == nums[idx]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            swap(nums, currIdx, idx);
            iterator(nums, ans, currIdx + 1);
            swap(nums, currIdx, idx);
        }

    }

}
