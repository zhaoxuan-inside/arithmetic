package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] mem = new int[nums.length + 1];
        for (int num : nums) {
            mem[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (mem[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
