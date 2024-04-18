package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class interview_weeel {

    public static void main(String[] args) {
        for (int num : sorting(new int[]{18, 65, 77, 79, 5, 41, 57, 72})) {
            System.out.print(num + " ");
        }
    }

    private static int[] sorting(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : arr) {
            map.computeIfAbsent(num / 20, k -> new ArrayList<>()).add(num);
        }
        boolean single = true;
        int[] ans = new int[arr.length];
        int idx = 0;
        for (Integer aisle : map.keySet()) {
            List<Integer> nums = map.get(aisle);
            nums.sort(Comparator.comparingInt(num -> num % 10));
            if (single) {
                for (Integer num : nums) {
                    ans[idx++] = num;
                }
            } else {
                for (int currIdx = nums.size() - 1; currIdx >= 0; currIdx--) {
                    ans[idx++] = nums.get(currIdx);
                }
            }
            single = !single;
        }
        return ans;
    }
}
