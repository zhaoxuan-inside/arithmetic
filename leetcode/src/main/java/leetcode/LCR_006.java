package leetcode;

@SuppressWarnings("unused")
public class LCR_006 {
    public int[] twoSum(int[] numbers, int target) {
        int idx1 = 0;
        int idx2 = numbers.length - 1;

        int[] ans = new int[2];

        while (idx1 < idx2) {
            int tmp = numbers[idx1] + numbers[idx2];
            if (tmp == target) {
                ans[0] = idx1;
                ans[1] = idx2;
                return ans;
            }

            if (tmp > target) {
                idx2--;
            } else {
                idx1++;
            }
        }
        return ans;
    }
}
